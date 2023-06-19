package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nrecinos.backend.models.dtos.category.CategoryInfoDto;
import com.nrecinos.backend.models.dtos.category.CreateCategoryDto;
import com.nrecinos.backend.models.dtos.category.UpdateCategoryDto;
import com.nrecinos.backend.models.entities.category.Category;
import com.nrecinos.backend.services.CategoryService;

@Service
public class CategoryServicesImpl implements CategoryService {
	
	@Autowired 
	//private CategoryRepository categoryRepository;
	
	@Override
	public CategoryInfoDto create(CreateCategoryDto info) {
		
		return null;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public Category save(Category category) {
		Category newCategory = new Category(
				category.getId(),
				category.getName(),
				category.getDescription());
		
		return null;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryInfoDto findOne(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryInfoDto update(Integer code, UpdateCategoryDto updateCategoryDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackOn = Execption.class)
	public void delete(Integer code) throws Exception {
		//caategoryRespository.deleteById(code);
		return null;
		
	}

}
