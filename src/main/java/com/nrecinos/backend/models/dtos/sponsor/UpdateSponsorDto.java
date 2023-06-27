package com.nrecinos.backend.models.dtos.sponsor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateSponsorDto {
	String name;
	Integer eventId;
}
