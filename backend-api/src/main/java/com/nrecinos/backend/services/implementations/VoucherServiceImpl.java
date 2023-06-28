package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.dtos.voucher.CreateVoucherDto;
import com.nrecinos.backend.models.dtos.voucher.VoucherInfoDto;
import com.nrecinos.backend.models.entities.user.User;
import com.nrecinos.backend.models.entities.voucher.Voucher;
import com.nrecinos.backend.repositories.UserRepository;
import com.nrecinos.backend.repositories.VoucherRepository;
import com.nrecinos.backend.services.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService{
	@Autowired
	VoucherRepository voucherRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public List<VoucherInfoDto> findAllByUser(Integer id) {
		List<Voucher> vouchers = voucherRepository.findAllByUserId(id);
		List<VoucherInfoDto> serializedVouchers = vouchers
				.stream()
				.map(voucher -> this.serializeVoucher(voucher))
				.toList();
		return serializedVouchers;
	}
	
	@Override
	public VoucherInfoDto create(CreateVoucherDto createVoucherDto) {
		User user = userRepository.findOneById(createVoucherDto.getUserId());
		Voucher newVoucher = new Voucher(createVoucherDto.getQuantity(), createVoucherDto.getTotal(), user);
		Voucher savedVoucher = this.save(newVoucher);
		return this.serializeVoucher(savedVoucher);
	}
	
	@Override
	public Voucher save(Voucher voucher) {
		return voucherRepository.save(voucher);
	}

	@Override
	public Voucher findOne(Integer id) {
		Voucher voucher = voucherRepository.findOneById(id);
		if (voucher == null) {			
			return null;
		}
		return voucher;
	}

	@Override
	public Voucher changeOwner(Integer currentOwner, Integer newOwner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VoucherInfoDto serializeVoucher(Voucher voucher) {
		VoucherInfoDto serializedVoucher = new VoucherInfoDto(
				voucher.getId(),
				voucher.getQuantity(),
				voucher.getTotal(),
				voucher.getUser().getId(),
				voucher.getUser().getName(),
				voucher.getUser().getLastname(),
				voucher.getUser().getEmail()
				);
		return serializedVoucher;
	}

}
