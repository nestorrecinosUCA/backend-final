package com.nrecinos.backend.models.dtos.voucher;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChangeOwnerDto {
	@NotNull(message = "currentOwnerId cannot be null")
	Integer currentOwnerId;

	@NotNull(message = "newOwnerId cannot be null")
	Integer newOwnerId;
}
