package com.nrecinos.backend.models.dtos.event;

import java.util.Date;

import com.nrecinos.backend.models.dtos.user.UserInfoDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventInfoDto {
	Integer id;
	String title;
	String description;
	Date date;
	String hour;
	Float duration;
	Integer assistantsCapacity;
	String image;
	UserInfoDto user;
	//String user;
	//String tier;
	//Integer category;
}
