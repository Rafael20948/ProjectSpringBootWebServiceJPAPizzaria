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
import com.project_java.demo.enums.TamanhoStatus;

@Entity
@Table(name = "tb_tamanho")
public class Tamanho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer tamanhoStatus;
	
	private Double desconto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tamanho")
	List<PizzaPedida> pizzaPedida = new ArrayList<>();
	
	public Tamanho() {
		
	}


	public Tamanho(Long id, Double desconto, TamanhoStatus tamanhoStatus) {
		this.id = id;
		this.desconto = desconto;
		setTamanhoStatus(tamanhoStatus);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}


	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	public Integer getPedidoStatus() {
		return tamanhoStatus;
	}

	public void setTamanhoStatus(TamanhoStatus tamanhoStatus) {
		if (tamanhoStatus != null) {
			this.tamanhoStatus = tamanhoStatus.getCode();
		}
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
		Tamanho other = (Tamanho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
