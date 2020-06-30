package com.project_java.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_java.demo.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}