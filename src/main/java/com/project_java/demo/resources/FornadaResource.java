package com.project_java.demo.resources;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_java.demo.entities.Fornada;
import com.project_java.demo.service.FornadaService;

	@RestController
	@RequestMapping(value = "/fornadas")
	public class FornadaResource {
		
		@Autowired
		private FornadaService service;

		@GetMapping
		public ResponseEntity<List<Fornada>> findAll() {
			List<Fornada> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Fornada> findById(@PathVariable Long id) {
			Fornada obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
		
}
