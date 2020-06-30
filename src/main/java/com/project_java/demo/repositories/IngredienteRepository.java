package com.project_java.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_java.demo.entities.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{
	
}