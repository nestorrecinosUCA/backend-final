package com.nrecinos.backend.models.dtos.sponsor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SponsorInfoDto {
	Integer id;
	String name;
	String eventName;
	Integer eventId;
}
