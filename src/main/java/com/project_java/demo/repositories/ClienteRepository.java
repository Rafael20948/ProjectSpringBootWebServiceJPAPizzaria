package com.project_java.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_java.demo.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}