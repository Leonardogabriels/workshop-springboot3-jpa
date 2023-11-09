package com.leonardo.webServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.webServices.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
