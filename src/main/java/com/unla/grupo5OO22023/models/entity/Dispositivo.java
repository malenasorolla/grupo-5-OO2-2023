package com.unla.grupo5OO22023.models.entity;

public abstract class Dispositivo {
//ATRIBUTOS
	protected int idDispositivo;
	protected boolean estado;
//CONSTRUCTORES 
	public Dispositivo() {
		super();
	}

	public Dispositivo(boolean estado) {
		super();
		this.estado = estado;
	}
//METODOS ABSTRACTOS QUE VAN A TENER TODOS LOS DISPOS
	public abstract void actualizarEstado();

	public int getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Dispositivo [idDispositivo=" + idDispositivo + ", estado=" + estado + "]";
	}

	
}
