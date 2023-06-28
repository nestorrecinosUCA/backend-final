package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.voucher.ChangeOwnerDto;
import com.nrecinos.backend.models.dtos.voucher.CreateVoucherDto;
import com.nrecinos.backend.models.dtos.voucher.VoucherInfoDto;
import com.nrecinos.backend.models.entities.voucher.Voucher;

public interface VoucherService {
	List<VoucherInfoDto> findAllByUser(Integer id);
	VoucherInfoDto create(CreateVoucherDto createVoucherDto);
	VoucherInfoDto findOne(Integer id);
	Voucher save(Voucher voucher);
	VoucherInfoDto changeOwner(Integer id, ChangeOwnerDto changeOwnerDto);
	VoucherInfoDto serializeVoucher(Voucher voucher);
}
