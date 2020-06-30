package com.project_java.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_java.demo.entities.Ingrediente;
import com.project_java.demo.service.IngredienteService;


@RestController
@RequestMapping(value = "/ingredientes")
public class IngredienteResource {
	
	@Autowired
	private IngredienteService service;

	@GetMapping
	public ResponseEntity<List<Ingrediente>> findAll() {
		List<Ingrediente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ingrediente> findById(@PathVariable Long id) {
		Ingrediente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
