package com.unla.grupo5OO22023.models.entity;

public abstract class Ambiente {
	//ATRIBUTOS
	protected int idAmbiente; 
	protected String nombre;
	
	//CONSTRUCTORES
	public Ambiente(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Ambiente() {
		super();
	} 
	//GETTERS AND SETTERS

	public int getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(int idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ambiente [idAmbiente=" + idAmbiente + ", nombre=" + nombre + "]";
	}
	
	
}
