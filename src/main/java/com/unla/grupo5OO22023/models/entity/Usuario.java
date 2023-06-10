package com.unla.grupo5OO22023.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombre")
	@NotEmpty(message = "El campo no puede estar vacio")
	private String nombre;

	@Column(name = "apellido")
	@NotEmpty(message = "El campo no puede estar vacio")
	private String apellido;

	@Column(name = "tipoDocumento")
	private String tipoDocumento;

	@Column(name = "documento")
	@NotNull
	private int documento;

	@Column(name = "correoElectronico")
	@Email
	private String correoElectronico;

	@Column(name = "nombreDeUsuario")
	@NotEmpty(message = "el campo no debe estar vacio")
	private String nombreDeUsuario;

	@Column(name = "contrasena")
	@NotEmpty(message = "el campo no debe estar vacio")
	private String contrasena;

	@ManyToOne
	@JoinColumn(name = "perfiles_id")
	private Perfiles perfiles;

	@Column(name = "deshabilitado")
	private boolean deshabilitado;

	public Usuario(long id, @NotEmpty(message = "El campo no puede estar vacio") String nombre,
			@NotEmpty(message = "El campo no puede estar vacio") String apellido, String tipoDocumento,
			@NotNull int documento, @Email String correoElectronico,
			@NotEmpty(message = "el campo no debe estar vacio") String nombreDeUsuario,
			@NotEmpty(message = "el campo no debe estar vacio") String contrasena, boolean deshabilitado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.correoElectronico = correoElectronico;
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasena = contrasena;
		this.deshabilitado = deshabilitado;
	}

	public Usuario(long id, String nombre, String apellido, String tipoDocumento, int documento,
			String correoElectronico, String nombreDeUsuario, String contrasena, Perfiles perfiles,
			boolean deshabilitado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.correoElectronico = correoElectronico;
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasena = contrasena;
		this.perfiles = perfiles;
		this.deshabilitado = deshabilitado;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoDocumento="
				+ tipoDocumento + ", documento=" + documento + ", correoElectronico=" + correoElectronico
				+ ", nombreDeUsuario=" + nombreDeUsuario + ", contrasena=" + contrasena + ", perfiles=" + perfiles
				+ ", deshabilitado=" + deshabilitado + "]";
	}
	
	

}
