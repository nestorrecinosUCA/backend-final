package com.nrecinos.backend.controllers.voucher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nrecinos.backend.models.dtos.ticket.TicketInfoDto;
import com.nrecinos.backend.models.dtos.voucher.VoucherInfoDto;
import com.nrecinos.backend.models.entities.user.User;
import com.nrecinos.backend.models.entities.voucher.Voucher;
import com.nrecinos.backend.repositories.UserRepository;
import com.nrecinos.backend.services.VoucherService;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {
	@Autowired
	VoucherService voucherService;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user/{id}")
	ResponseEntity<?> getAll(@PathVariable(name = "id") Integer id){
		User user = userRepository.findOneById(id);
		if (user == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		List<VoucherInfoDto> vouchers = voucherService.findAllByUser(id);
		return new ResponseEntity<>(vouchers, HttpStatus.OK);
	} 
}
