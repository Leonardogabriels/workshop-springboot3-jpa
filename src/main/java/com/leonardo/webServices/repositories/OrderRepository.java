package com.leonardo.webServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.webServices.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
