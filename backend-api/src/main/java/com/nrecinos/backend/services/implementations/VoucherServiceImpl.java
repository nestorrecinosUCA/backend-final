package com.nrecinos.backend.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.entities.voucher.Voucher;
import com.nrecinos.backend.repositories.VoucherRepository;
import com.nrecinos.backend.services.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService{
	@Autowired
	VoucherRepository voucherRepository;

	@Override
	public Voucher findAllByUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
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

}
