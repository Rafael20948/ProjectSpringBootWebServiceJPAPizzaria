package com.project_java.demo.resources;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_java.demo.entities.Pizza;
import com.project_java.demo.service.PizzaService;

	@RestController
	@RequestMapping(value = "/pizzas")
	public class PizzaResource {
		
		@Autowired
		private PizzaService service;

		@GetMapping
		public ResponseEntity<List<Pizza>> findAll() {
			List<Pizza> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Pizza> findById(@PathVariable Long id) {
			Pizza obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
		
}
