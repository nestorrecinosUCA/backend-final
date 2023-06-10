package com.nrecinos.backend.controllers.category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nrecinos.backend.models.dtos.category.CategoryInfoDto;
import com.nrecinos.backend.models.dtos.category.CreateCategoryDto;
import com.nrecinos.backend.models.dtos.category.UpdateCategoryDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryControllers {

	@PostMapping("/")
	ResponseEntity<?> create(@RequestBody @Valid CreateCategoryDto craeteCategoryDto, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	ResponseEntity<?> getAll(){
		//List<Category> category = categoryService.getAll();
		//if(category == null) {
		//	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		//}
		return new ResponseEntity<>("All category", HttpStatus.OK);
	} 
	
	@GetMapping("/{code}")
	ResponseEntity<?> getCategoryById(@PathVariable(name = "code") Integer code){
		CategoryInfoDto category = null; //TODO: Update with service method
		if(category == null) {
			return new ResponseEntity<>("Category not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PatchMapping("/{code}")
	ResponseEntity<?> updateCatgeory(@PathVariable(name = "code") Integer code, @RequestBody @Valid UpdateCategoryDto updateCategoryDto, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Update Successfully", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{code}")
	ResponseEntity<?> delete(@PathVariable(name = "code") Integer code){
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
