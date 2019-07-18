package com.demo.app.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class Usuario implements Serializable {
	@Id
	@Column(name="idusuario")
	private int idUsuario;
	@Column(name="nombreusuario") 
	private String nombreUsuario;
	@Column(name="contrasenia")
	private String contrasenia;
	@Column(name="correo")
	private String correo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	
	public Usuario(int idUsuario, String nombreUsuario, String contrasenia, String correo, String nombre,
			String apellido) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public Usuario(String nombreUsuario, String contrasenia, String correo, String nombre,
			String apellido) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public Usuario() {
		
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia
				+ ", correo=" + correo + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	

}


