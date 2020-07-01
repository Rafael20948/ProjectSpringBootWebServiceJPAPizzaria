package com.project_java.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_java.demo.entities.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{
	
}