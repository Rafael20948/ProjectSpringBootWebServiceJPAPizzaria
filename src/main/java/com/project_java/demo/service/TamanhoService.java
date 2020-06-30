package com.project_java.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_java.demo.entities.Tamanho;
import com.project_java.demo.repositories.TamanhoRepository;

@Service
public class TamanhoService {

	@Autowired
	private TamanhoRepository repository;

	public List<Tamanho> findAll() {
		return repository.findAll();
	}

	public Tamanho findById(Long id) {
		Optional<Tamanho> obj = repository.findById(id);
		return obj.get();
	}
}
