package com.leonardo.webServices.repositories;

import com.leonardo.webServices.entities.Payment;
import com.leonardo.webServices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
}
