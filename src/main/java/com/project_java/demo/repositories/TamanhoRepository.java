package com.project_java.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_java.demo.entities.Tamanho;

public interface TamanhoRepository extends JpaRepository<Tamanho, Long>{
	
}