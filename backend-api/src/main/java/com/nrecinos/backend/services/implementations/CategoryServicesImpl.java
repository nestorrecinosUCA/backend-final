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
	public Category create(CreateCategoryDto info) {
		Category newCategory = new Category(
				info.getName(), 
				info.getDescription()
				);
		Category saveCategory = this.save(newCategory);
		
		return saveCategory;
	}
	

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findOne(Integer code) {
		Category category = categoryRepository.findOneById(code);
		if(category == null) {
			return null;
		}
		return category;
	}

	@Override
	public Category update(Integer code, UpdateCategoryDto updateCategoryDto) {
		Category categoryToUpdate = findOne(code);
		if(categoryToUpdate == null) {
			return null;
		}
		if (updateCategoryDto.getName() != null) {
			categoryToUpdate.setName(updateCategoryDto.getName());
		}
		if (updateCategoryDto.getDescription() != null) {
			categoryToUpdate.setDescription(updateCategoryDto.getDescription());
		}
		Category updatedCategory = this.save(categoryToUpdate);
		return updatedCategory;
		
	}

	@Override
	public void delete(Integer code) {
		 categoryRepository.deleteById(code);
	}

}
