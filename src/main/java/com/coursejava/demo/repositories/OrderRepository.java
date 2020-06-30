package com.coursejava.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coursejava.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
