package com.nrecinos.backend.controllers.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.nrecinos.backend.models.dtos.category.CreateCategoryDto;
import com.nrecinos.backend.models.dtos.category.UpdateCategoryDto;
import com.nrecinos.backend.models.entities.category.Category;
import com.nrecinos.backend.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryControllers {
	@Autowired
	CategoryService categoryService;

	@PostMapping("")
	ResponseEntity<?> create(@RequestBody @Valid CreateCategoryDto createCategoryDto, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		Category newCategory = categoryService.create(createCategoryDto);
		return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
	}
	
	@GetMapping("")
	ResponseEntity<?> getAll(){
		List<Category> categories = categoryService.findAll();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	} 
	
	@GetMapping("/{code}")
	ResponseEntity<?> getCategoryById(@PathVariable(name = "code") Integer code){
		Category category = categoryService.findOne(code); //TODO: Update with service method
		if(category == null) {
			return new ResponseEntity<>("Category not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(category, HttpStatus.CREATED);
	}
	
	@PatchMapping("/{code}")
	ResponseEntity<?> updateCatgeory(@PathVariable(name = "code") Integer code, @RequestBody @Valid UpdateCategoryDto updateCategoryDto, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		Category category = categoryService.findOne(code);
		if(category == null) {
			return new ResponseEntity<>("Category not Found", HttpStatus.NOT_FOUND);
		}
		Category updatedCategory = categoryService.update(code, updateCategoryDto);
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{code}")
	ResponseEntity<?> delete(@PathVariable(name = "code") Integer code){
		Category category = categoryService.findOne(code);
		if(category == null) {
			return new ResponseEntity<>("Category not Found", HttpStatus.NOT_FOUND);
		}
		categoryService.delete(code);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
