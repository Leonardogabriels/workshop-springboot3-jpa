package com.leonardo.webServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.webServices.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
