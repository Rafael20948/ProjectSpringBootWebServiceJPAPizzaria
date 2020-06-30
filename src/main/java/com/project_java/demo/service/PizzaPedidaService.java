package com.project_java.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_java.demo.entities.PizzaPedida;
import com.project_java.demo.repositories.PizzaPedidaRepository;

@Service
public class PizzaPedidaService {

	@Autowired
	private PizzaPedidaRepository repository;

	public List<PizzaPedida> findAll() {
		return repository.findAll();
	}
	
	public PizzaPedida findById(Long id) {
		Optional<PizzaPedida> obj = repository.findById(id);
		return obj.get();
	}
}

