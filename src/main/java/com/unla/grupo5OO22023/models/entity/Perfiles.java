package com.unla.grupo5OO22023.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "perfiles", uniqueConstraints = {@UniqueConstraint(columnNames = {"rol"})})
public class Perfiles implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name="rol")
	@NotEmpty
	private String rol; 
	
	public Perfiles(long id, String rol) {
		super();
		this.id = id;
		this.rol = rol;
	}

	public Perfiles(String rol) {
		super();
		this.rol = rol;
	}

	@Override
	public String toString() {
		return rol;
	}

	
}
