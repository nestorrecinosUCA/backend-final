package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.dtos.staff.CreateStaffDto;
import com.nrecinos.backend.models.dtos.staff.StaffInfoDto;
import com.nrecinos.backend.models.dtos.staff.UpdateStaffDto;
import com.nrecinos.backend.models.entities.staff.Staff;
import com.nrecinos.backend.services.StaffService;

@Service
public class StaffServiceImpl implements StaffService{

	@Override
	public StaffInfoDto create(CreateStaffDto createCategoryDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Staff save(Staff category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Staff> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffInfoDto findOne(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffInfoDto update(Integer code, UpdateStaffDto updateStaffDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer code) {
		// TODO Auto-generated method stub
		
	}

}
