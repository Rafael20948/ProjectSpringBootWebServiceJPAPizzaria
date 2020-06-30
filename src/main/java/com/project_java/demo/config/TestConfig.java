package com.project_java.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project_java.demo.entities.Cliente;
import com.project_java.demo.repositories.ClienteRepository;

	@Configuration
	@Profile("test")
	public class TestConfig implements CommandLineRunner {

		@Autowired
		private ClienteRepository clienteRepository;
		
		@Override
		public void run(String... args) throws Exception {
			
			Cliente cli1 = new Cliente(null, "rafael", 12345678, "Rua Euclides", "rafael@gmail.com", "1a2s3d4f");
			
			clienteRepository.saveAll(Arrays.asList(cli1));
		}
	
}
