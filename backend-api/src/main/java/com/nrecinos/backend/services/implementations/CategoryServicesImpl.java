package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nrecinos.backend.models.dtos.category.CategoryInfoDto;
import com.nrecinos.backend.models.dtos.category.CreateCategoryDto;
import com.nrecinos.backend.models.dtos.category.UpdateCategoryDto;
import com.nrecinos.backend.models.entities.category.Category;
import com.nrecinos.backend.repositories.CategoryRepository;
import com.nrecinos.backend.services.CategoryService;

@Service
public class CategoryServicesImpl implements CategoryService {
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Override
	public CategoryInfoDto create(CreateCategoryDto info) {
		Category newCategory = new Category(
				info.getName(), 
				info.getDescription()
				);
		Category saveCategory = this.save(newCategory);
		CategoryInfoDto categoryInfo = this.serializeCategoryInfoDto(saveCategory);
		
		return categoryInfo;
	}
	
	@Override
	public CategoryInfoDto serializeCategoryInfoDto(Category category) {
		return new CategoryInfoDto(category.getName(), category.getDescription());
	}
	

	@Override
	//@Transactional(rollbackOn = Exception.class)
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
		
	}

	@Override
	public CategoryInfoDto findOne(Integer code) {
		Category category = categoryRepository.findOneById(code);
		if(category == null) {
		return null;
		}
		CategoryInfoDto categoryInfo = this.serializeCategoryInfoDto(category);
		return categoryInfo;
	}

	@Override
	public CategoryInfoDto update(Integer code, UpdateCategoryDto updateCategoryDto) {
		
		CategoryInfoDto categoryDto = findOne(code);
		
		if(categoryDto == null) {
			return null;
		}
		Category category = new Category(
				updateCategoryDto.getName(),
				updateCategoryDto.getDescription());
		 categoryRepository.save(category);
		 CategoryInfoDto categoryInfo = this.serializeCategoryInfoDto(category);
		return categoryInfo;
		
	}

	@Override
	//@Transactional(rollbackOn = ExCeption.class)
	public void delete(Integer code) {
		 categoryRepository.deleteById(code);
	}

}
