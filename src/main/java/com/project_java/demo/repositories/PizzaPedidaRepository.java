package com.project_java.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_java.demo.entities.PizzaPedida;

public interface PizzaPedidaRepository extends JpaRepository<PizzaPedida, Long>{
	
}