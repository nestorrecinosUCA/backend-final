package com.nrecinos.backend.controllers.voucher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nrecinos.backend.models.dtos.user.UserInfoDto;
import com.nrecinos.backend.models.dtos.voucher.CreateVoucherDto;
import com.nrecinos.backend.models.dtos.voucher.VoucherInfoDto;
import com.nrecinos.backend.models.entities.user.User;
import com.nrecinos.backend.repositories.UserRepository;
import com.nrecinos.backend.services.UserService;
import com.nrecinos.backend.services.VoucherService;
import com.nrecinos.backend.utils.RequestErrorsHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {
	@Autowired
	VoucherService voucherService;
	@Autowired
	UserService userService;
	
	@Autowired
	RequestErrorsHandler errorsHandler;
	
	@GetMapping("/user/{id}")
	ResponseEntity<?> getAll(@PathVariable(name = "id") Integer id){
		UserInfoDto user = userService.findOne(id);
		if (user == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		List<VoucherInfoDto> vouchers = voucherService.findAllByUser(id);
		return new ResponseEntity<>(vouchers, HttpStatus.OK);
	} 
	
	@PostMapping("")
	ResponseEntity<?> createVoucher(@RequestBody @Valid CreateVoucherDto createVoucherDto, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(
					errorsHandler.mapErrors(validations.getFieldErrors()),
					HttpStatus.BAD_REQUEST);
		}
		UserInfoDto user = userService.findOne(createVoucherDto.getUserId());
		if (user == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		VoucherInfoDto voucher = voucherService.create(createVoucherDto);
		return new ResponseEntity<>(voucher, HttpStatus.OK);
	}
}
