package com.project_java.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project_java.demo.entities.Cliente;
import com.project_java.demo.entities.Pedido;
import com.project_java.demo.enums.OrderPedido;
import com.project_java.demo.repositories.ClienteRepository;
import com.project_java.demo.repositories.PedidoRepository;

@Configuration
	@Profile("test")
	public class TestConfig implements CommandLineRunner {

		@Autowired
		private ClienteRepository clienteRepository;
		
		@Autowired
		private PedidoRepository pedidoRepository;
		
		@Override
		public void run(String... args) throws Exception {

			
			Cliente cli1 = new Cliente(null, "rafael", 12345678, "Rua Euclides", "rafael@gmail.com", "1a2s3d4f");
			Cliente cli2 = new Cliente(null, "jonas", 2434678, "Rua Juventus", "jonas@gmail.com", "osdihda");
			Cliente cli3 = new Cliente(null, "diego", 1455378, "Rua Fernades", "diego@gmail.com", "1eoncf");
			
			clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));
			
			Pedido ped1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), OrderPedido.MEDIA, cli1);
			Pedido ped2 = new Pedido(null, Instant.parse("2014-12-20T12:35:02Z"), OrderPedido.MAXIMA, cli2);
			Pedido ped3 = new Pedido(null, Instant.parse("2013-04-20T14:23:17Z"), OrderPedido.MINIMA, cli3);
			
			pedidoRepository.saveAll(Arrays.asList(ped1,ped2,ped3));
			

		}
	
}
