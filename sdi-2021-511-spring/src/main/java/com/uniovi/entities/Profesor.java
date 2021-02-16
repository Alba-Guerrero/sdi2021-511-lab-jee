package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Profesor {
	@Id
	@GeneratedValue
	private Long id;
	private String DNI;
	 private String nombre;
	 private String Apellidos;
	 private String categoria;
	 
	 
	
	
	
	
	
	public Profesor() {
		super();
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}


	public Profesor( String dNI, String nombre, String apellidos, String categoria) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		Apellidos = apellidos;
		this.categoria = categoria;
	}


	public Profesor( Long id,String dNI, String nombre, String apellidos, String categoria) {
		super();
		this.id=id;
		DNI = dNI;
		this.nombre = nombre;
		Apellidos = apellidos;
		this.categoria = categoria;
	}





	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}





	@Override
	public String toString() {
		return "Profesor [DNI=" + DNI + ", nombre=" + nombre + ", Apellidos=" + Apellidos + ", categoria=" + categoria
				+ "]";
	}
	 
	
	
	 

}
