package com.nrecinos.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrecinos.backend.models.entities.voucher.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Integer>{
	List<Voucher> findAllByUserId(Integer id);
	Voucher findOneById(Integer id);
}
