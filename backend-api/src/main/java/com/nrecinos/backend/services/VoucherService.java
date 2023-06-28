package com.nrecinos.backend.services;

import com.nrecinos.backend.models.entities.voucher.Voucher;

public interface VoucherService {
	Voucher findAllByUser(Integer id);
	Voucher findOne(Integer id);
	Voucher changeOwner(Integer currentOwner, Integer newOwner);
}
