package com.project_java.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project_java.demo.enums.BebidaStatus;

@Entity
@Table(name = "tb_bebida")
public class Bebida implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer tipo;
	private Double preco;
	private Integer quantidade;

	@JsonIgnore
	@OneToMany(mappedBy = "bebida")
	List<Pedido> pedido = new ArrayList<>();
	
	public Bebida() {
		
	}

	public Bebida(Long id, BebidaStatus tipo, Double preco, Integer quantidade) {
		this.id = id;
		setBebidaStatus(tipo);
		this.preco = preco;
		this.setQuantidade(quantidade);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getBebidaStatus() {
		return tipo;
	}
	
	public void setBebidaStatus(BebidaStatus tipo) {
		if (tipo != null) {
			this.tipo = tipo.getCode();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bebida other = (Bebida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
