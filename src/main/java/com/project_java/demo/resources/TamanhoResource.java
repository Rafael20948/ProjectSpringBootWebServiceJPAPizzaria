package com.project_java.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_java.demo.entities.Tamanho;
import com.project_java.demo.service.TamanhoService;


@RestController
@RequestMapping(value = "/tamanhos")
public class TamanhoResource {
	
	@Autowired
	private TamanhoService service;

	@GetMapping
	public ResponseEntity<List<Tamanho>> findAll() {
		List<Tamanho> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tamanho> findById(@PathVariable Long id) {
		Tamanho obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
