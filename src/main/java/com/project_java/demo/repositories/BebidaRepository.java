package com.project_java.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_java.demo.entities.Bebida;

public interface BebidaRepository extends JpaRepository<Bebida, Long>{
	
}