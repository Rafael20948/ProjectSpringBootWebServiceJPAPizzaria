package com.project_java.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_fornada")
public class Fornada implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer numeroDePizzas;
	private Integer numeroFornada;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Pedido pedido;
	
	public Fornada() {

	}

	public Fornada(Long id, Integer numeroDePizzas, Integer numeroFornada, Pedido pedido) {
		this.id = id;
		this.numeroDePizzas = numeroDePizzas;
		this.numeroFornada = numeroFornada;
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getnumeroDePizzas() {
		return numeroDePizzas;
	}

	public void setnumeroDePizzas(Integer numeroDePizzas) {
		this.numeroDePizzas = numeroDePizzas;
	}

	public Integer getNumeroFornada() {
		return numeroFornada;
	}

	public void setNumeroFornada(Integer numeroFornada) {
		this.numeroFornada = numeroFornada;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
		Fornada other = (Fornada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
