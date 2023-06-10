package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.category.CategoryInfoDto;
import com.nrecinos.backend.models.dtos.category.CreateCategoryDto;
import com.nrecinos.backend.models.entities.category.Category;

public interface CategoryService {
	CategoryInfoDto create(CreateCategoryDto createCategoryDto);
	Category save(Category category);
	List<Category> findAll();
	CategoryInfoDto findOne(Integer code);
	CategoryInfoDto update(Integer code);
	void delete(Integer code);
}
