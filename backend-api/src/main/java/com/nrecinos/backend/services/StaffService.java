package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.staff.CreateStaffDto;
import com.nrecinos.backend.models.dtos.staff.StaffInfoDto;
import com.nrecinos.backend.models.dtos.staff.UpdateStaffDto;
import com.nrecinos.backend.models.entities.staff.Staff;

public interface StaffService {
	StaffInfoDto create(CreateStaffDto createCategoryDto);
	Staff save(Staff category);
	List<Staff> findAll();
	StaffInfoDto findOne(Integer code);
	StaffInfoDto update(Integer code, UpdateStaffDto updateStaffDto);
	void delete(Integer code);
}
