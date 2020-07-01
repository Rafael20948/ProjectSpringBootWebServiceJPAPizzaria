package com.project_java.demo.resources;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_java.demo.entities.Bebida;
import com.project_java.demo.service.BebidaService;

	@RestController
	@RequestMapping(value = "/bebidas")
	public class BebidaResource {
		
		@Autowired
		private BebidaService service;

		@GetMapping
		public ResponseEntity<List<Bebida>> findAll() {
			List<Bebida> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Bebida> findById(@PathVariable Long id) {
			Bebida obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
		
}
