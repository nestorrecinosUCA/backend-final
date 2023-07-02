package com.nrecinos.backend.models.dtos.voucher;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VoucherInfoDto {
	Integer id;
	Integer quantity;
	Integer total;
	Integer userId;
	String userName;
	String userLastname;
	String userEmail;
}
