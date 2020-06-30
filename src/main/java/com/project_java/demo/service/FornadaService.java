package com.project_java.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_java.demo.entities.Fornada;
import com.project_java.demo.repositories.FornadaRepository;

@Service
public class FornadaService {

	@Autowired
	private FornadaRepository repository;

	public List<Fornada> findAll() {
		return repository.findAll();
	}
	
	public Fornada findById(Long id) {
		Optional<Fornada> obj = repository.findById(id);
		return obj.get();
	}
}

