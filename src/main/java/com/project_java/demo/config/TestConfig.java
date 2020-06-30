package com.project_java.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project_java.demo.entities.Cliente;
import com.project_java.demo.entities.Ingrediente;
import com.project_java.demo.entities.Pedido;
import com.project_java.demo.entities.PizzaPedida;
import com.project_java.demo.entities.Tamanho;
import com.project_java.demo.enums.PedidoStatus;
import com.project_java.demo.enums.TamanhoStatus;
import com.project_java.demo.repositories.ClienteRepository;
import com.project_java.demo.repositories.IngredienteRepository;
import com.project_java.demo.repositories.PedidoRepository;
import com.project_java.demo.repositories.PizzaPedidaRepository;
import com.project_java.demo.repositories.TamanhoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private TamanhoRepository tamanhoRepository;

	@Autowired
	private PizzaPedidaRepository pizzaPedidaRepository;

	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Cliente cli1 = new Cliente(null, "rafael", 12345678, "Rua Euclides", "rafael@gmail.com", "1a2s3d4f");
		Cliente cli2 = new Cliente(null, "jonas", 2434678, "Rua Juventus", "jonas@gmail.com", "osdihda");
		Cliente cli3 = new Cliente(null, "diego", 1455378, "Rua Fernades", "diego@gmail.com", "1eoncf");

		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));

		Pedido ped1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.MEDIA, cli1);
		Pedido ped2 = new Pedido(null, Instant.parse("2014-12-20T12:35:02Z"), PedidoStatus.MAXIMA, cli2);
		Pedido ped3 = new Pedido(null, Instant.parse("2013-04-20T14:23:17Z"), PedidoStatus.MINIMA, cli3);

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));

		Tamanho tam1 = new Tamanho(null, 20.00, TamanhoStatus.GRANDE);
		Tamanho tam2 = new Tamanho(null, 50.00, TamanhoStatus.MEDIA);
		Tamanho tam3 = new Tamanho(null, 70.00, TamanhoStatus.PEQUENA);

		tamanhoRepository.saveAll(Arrays.asList(tam1, tam2, tam3));

		PizzaPedida pp1 = new PizzaPedida(null, 2, tam1);
		PizzaPedida pp2 = new PizzaPedida(null, 1, tam2);
		PizzaPedida pp3 = new PizzaPedida(null, 4, tam3);

		pizzaPedidaRepository.saveAll(Arrays.asList(pp1, pp2, pp3));
		
		Ingrediente ig1 = new Ingrediente(null, "Queijo", 15.00);
		Ingrediente ig2 = new Ingrediente(null, "Salame", 25.00);
		Ingrediente ig3 = new Ingrediente(null, "Tomate", 3.00);
		
		ingredienteRepository.saveAll(Arrays.asList(ig1, ig2, ig3));
		
		pp1.getIngredientes().add(ig1);
		pp2.getIngredientes().add(ig2);
		pp2.getIngredientes().add(ig3);
		pp2.getIngredientes().add(ig3);
		pp3.getIngredientes().add(ig1);
		
		pizzaPedidaRepository.saveAll(Arrays.asList(pp1,pp2,pp3));
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
