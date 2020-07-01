package com.project_java.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_java.demo.entities.Pizza;
import com.project_java.demo.repositories.PizzaRepository;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository repository;

	public List<Pizza> findAll() {
		return repository.findAll();
	}
	
	public Pizza findById(Long id) {
		Optional<Pizza> obj = repository.findById(id);
		return obj.get();
	}
}

