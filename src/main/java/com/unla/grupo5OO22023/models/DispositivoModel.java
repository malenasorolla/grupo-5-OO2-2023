package com.unla.grupo5OO22023.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DispositivoModel {
	protected int idDispositivo;
	protected boolean estado;
	protected String nombre;
	public DispositivoModel(int idDispositivo, boolean estado, String nombre) {
		super();
		this.idDispositivo = idDispositivo;
		this.estado = estado;
		this.nombre = nombre;
	}
	
}