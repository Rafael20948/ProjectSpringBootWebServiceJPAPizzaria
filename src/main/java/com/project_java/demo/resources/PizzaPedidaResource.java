package com.project_java.demo.resources;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_java.demo.entities.PizzaPedida;
import com.project_java.demo.service.PizzaPedidaService;

	@RestController
	@RequestMapping(value = "/pizza_pedidas")
	public class PizzaPedidaResource {
		
		@Autowired
		private PizzaPedidaService service;

		@GetMapping
		public ResponseEntity<List<PizzaPedida>> findAll() {
			List<PizzaPedida> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<PizzaPedida> findById(@PathVariable Long id) {
			PizzaPedida obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
		
}
