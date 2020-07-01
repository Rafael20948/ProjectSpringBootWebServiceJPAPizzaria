package com.project_java.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pizza_pedido")
public class PizzaPedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "tamanho_id")
	private Tamanho tamanho;
	
	@ManyToOne
	@JoinColumn(name = "pizza_id")
	private Pizza pizza;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToMany
	@JoinTable(name = "tb_pizzaPedida_ingrediente", joinColumns = @JoinColumn(name = "pizzaPedida_id"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
	private Set<Ingrediente> ingredientes = new HashSet<>();

	public PizzaPedida() {
	
	}

	public PizzaPedida(Long id, Integer quantidade, Tamanho tamanho, Pizza pizza, Pedido pedido) {
		this.id = id;
		this.quantidade = quantidade;
		this.tamanho = tamanho;
		this.pizza = pizza;
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	
	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
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
		PizzaPedida other = (PizzaPedida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
