package com.project_java.demo.resources;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_java.demo.entities.Cliente;
import com.project_java.demo.service.ClienteService;

	@RestController
	@RequestMapping(value = "/Clientes")
	public class ClienteResource {
		
		@Autowired
		private ClienteService service;

		@GetMapping
		public ResponseEntity<List<Cliente>> findAll() {
			List<Cliente> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Cliente> findById(@PathVariable Long id) {
			Cliente obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
		
}
