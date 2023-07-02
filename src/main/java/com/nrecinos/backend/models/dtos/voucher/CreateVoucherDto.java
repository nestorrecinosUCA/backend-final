package com.nrecinos.backend.models.dtos.voucher;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateVoucherDto {
	@NotNull(message = "quantity cannot be null")
	@Positive()
	private Integer quantity; 
	
	@NotNull(message = "total cannot be null")
	@Positive()
	private Integer total;
	
	@NotNull(message = "userId cannot be bull")
	@Positive()
	private Integer userId;

}
