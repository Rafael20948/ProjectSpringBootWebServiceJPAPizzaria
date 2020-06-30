package com.project_java.demo.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project_java.demo.enums.PedidoStatus;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant horario;
	
	private Integer pedidoStatus;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Pedido() {
		
	}

	public Pedido(Long id, Instant horario, PedidoStatus pedidoStatus, Cliente cliente) {
		this.id = id;
		this.horario = horario;
		setOrderPedido(pedidoStatus);
		this.cliente = cliente;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant gethorario() {
		return horario;
	}

	public void sethorario(Instant horario) {
		this.horario = horario;
	}

	public Integer getOrderPedido() {
		return pedidoStatus;
	}

	public void setOrderPedido(PedidoStatus orderPedido) {
		if (orderPedido != null) {
			this.pedidoStatus = orderPedido.getCode();
		}
	}
	
	public Cliente getClient() {
		return cliente;
	}

	public void setClient(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
