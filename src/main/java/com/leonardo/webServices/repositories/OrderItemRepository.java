package com.leonardo.webServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.webServices.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
