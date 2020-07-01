package com.project_java.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_java.demo.entities.Bebida;
import com.project_java.demo.repositories.BebidaRepository;

@Service
public class BebidaService {

	@Autowired
	private BebidaRepository repository;

	public List<Bebida> findAll() {
		return repository.findAll();
	}
	
	public Bebida findById(Long id) {
		Optional<Bebida> obj = repository.findById(id);
		return obj.get();
	}
}

