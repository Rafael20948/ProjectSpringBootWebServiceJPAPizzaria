package com.project_java.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project_java.demo.entities.Bebida;
import com.project_java.demo.entities.Cliente;
import com.project_java.demo.entities.Fornada;
import com.project_java.demo.entities.Ingrediente;
import com.project_java.demo.entities.Pedido;
import com.project_java.demo.entities.Pizza;
import com.project_java.demo.entities.PizzaPedida;
import com.project_java.demo.entities.Tamanho;
import com.project_java.demo.enums.BebidaStatus;
import com.project_java.demo.enums.PedidoStatus;
import com.project_java.demo.enums.PizzaStatus;
import com.project_java.demo.enums.TamanhoStatus;
import com.project_java.demo.repositories.BebidaRepository;
import com.project_java.demo.repositories.ClienteRepository;
import com.project_java.demo.repositories.IngredienteRepository;
import com.project_java.demo.repositories.PedidoRepository;
import com.project_java.demo.repositories.PizzaPedidaRepository;
import com.project_java.demo.repositories.PizzaRepository;
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

	@Autowired
	private BebidaRepository bebidaRepository;

	@Autowired
	private PizzaRepository pizzaRepository;

	@Override
	public void run(String... args) throws Exception {

		Cliente cli1 = new Cliente(null, "rafael", 12345678, "Rua Euclides", "rafael@gmail.com", "1a2s3d4f");
		Cliente cli2 = new Cliente(null, "jonas", 2434678, "Rua Juventus", "jonas@gmail.com", "osdihda");
		Cliente cli3 = new Cliente(null, "diego", 1455378, "Rua Fernades", "diego@gmail.com", "1eoncf");

		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));

		Tamanho tam1 = new Tamanho(null, 20.00, TamanhoStatus.GRANDE);
		Tamanho tam2 = new Tamanho(null, 50.00, TamanhoStatus.MEDIA);
		Tamanho tam3 = new Tamanho(null, 70.00, TamanhoStatus.PEQUENA);

		tamanhoRepository.saveAll(Arrays.asList(tam1, tam2, tam3));

		Pizza p1 = new Pizza(null, "Calabreza", 32.00, PizzaStatus.NÃO);
		Pizza p2 = new Pizza(null, "Frango-Catupiry", 38.00, PizzaStatus.SIM);
		Pizza p3 = new Pizza(null, "Portuguesa", 22.00, PizzaStatus.SIM);
		Pizza p4 = new Pizza(null, "Baiana", 42.00, PizzaStatus.NÃO);

		pizzaRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		Ingrediente ig1 = new Ingrediente(null, "Queijo", 15.00);
		Ingrediente ig2 = new Ingrediente(null, "Salame", 25.00);
		Ingrediente ig3 = new Ingrediente(null, "Tomate", 3.00);

		ingredienteRepository.saveAll(Arrays.asList(ig1, ig2, ig3));

		Bebida b1 = new Bebida(null, BebidaStatus.CAIPIRINHA, 15.00, 2);
		Bebida b2 = new Bebida(null, BebidaStatus.CERVEJA, 5.00, 3);
		Bebida b3 = new Bebida(null, BebidaStatus.REFRIGERANTE, 8.00, 3);
		Bebida b4 = new Bebida(null, BebidaStatus.SUCO, 12.00, 1);
		Bebida b5 = new Bebida(null, BebidaStatus.CAIPIRINHA, 15.00, 4);

		bebidaRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5));

		Pedido ped1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.MEDIA, cli1, b1);
		Pedido ped2 = new Pedido(null, Instant.parse("2014-12-20T12:35:02Z"), PedidoStatus.MAXIMA, cli2, b2);
		Pedido ped3 = new Pedido(null, Instant.parse("2013-04-20T14:23:17Z"), PedidoStatus.MINIMA, cli3, b3);

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));

		Fornada f1 = new Fornada(null, 12, 15, ped1);
		ped1.setFornada(f1);

		pedidoRepository.save(ped1);

		PizzaPedida pp1 = new PizzaPedida(null, 2, tam1, p1, ped1);
		PizzaPedida pp2 = new PizzaPedida(null, 1, tam2, p2, ped2);
		PizzaPedida pp3 = new PizzaPedida(null, 4, tam3, p3, ped3);
		PizzaPedida pp4 = new PizzaPedida(null, 2, tam2, p3, ped3);

		pizzaPedidaRepository.saveAll(Arrays.asList(pp1, pp2, pp3, pp4));

		pp1.getIngredientes().add(ig1);
		pp2.getIngredientes().add(ig2);
		pp2.getIngredientes().add(ig3);
		pp2.getIngredientes().add(ig3);
		pp3.getIngredientes().add(ig1);

		pizzaPedidaRepository.saveAll(Arrays.asList(pp1, pp2, pp3));
	}
}
