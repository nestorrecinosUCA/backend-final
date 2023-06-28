package com.nrecinos.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrecinos.backend.models.entities.voucher.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Integer>{
	Voucher findOneById(Integer id);
}
