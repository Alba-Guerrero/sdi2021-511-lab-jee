package com.uniovi.sdi;

public class Comentario {

	private String comentario;
	private String usuario;
	
	
	
	public Comentario() {
		super();
	}
	
	
	
	public Comentario(String usuario, String comentario) {
		super();
		this.comentario = comentario;
		this.usuario = usuario;
	}



	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
