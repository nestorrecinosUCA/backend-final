package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.category.CreateCategoryDto;
import com.nrecinos.backend.models.dtos.category.UpdateCategoryDto;
import com.nrecinos.backend.models.entities.category.Category;

public interface CategoryService {
	Category create(CreateCategoryDto createCategoryDto);
	Category save(Category category);
	List<Category> findAll();
	Category findOne(Integer code);
	Category update(Integer code, UpdateCategoryDto updateCategoryDto);
	void delete(Integer code);
}
