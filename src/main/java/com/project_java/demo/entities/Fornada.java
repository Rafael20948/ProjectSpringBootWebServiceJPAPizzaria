package com.project_java.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fornada")
public class Fornada implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double numeroPizza;
	private Double numeroFornada;
	
	public Fornada() {

	}

	public Fornada(Long id, Double numeroPizza, Double numeroFornada) {
		this.id = id;
		this.numeroPizza = numeroPizza;
		this.numeroFornada = numeroFornada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getNumeroPizza() {
		return numeroPizza;
	}

	public void setNumeroPizza(Double numeroPizza) {
		this.numeroPizza = numeroPizza;
	}

	public Double getNumeroFornada() {
		return numeroFornada;
	}

	public void setNumeroFornada(Double numeroFornada) {
		this.numeroFornada = numeroFornada;
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
