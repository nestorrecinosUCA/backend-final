package com.nrecinos.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrecinos.backend.models.entities.category.Category;



public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Category findOneById(Integer id);
	
}
