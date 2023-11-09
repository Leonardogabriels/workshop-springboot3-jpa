package com.leonardo.webServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.webServices.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
