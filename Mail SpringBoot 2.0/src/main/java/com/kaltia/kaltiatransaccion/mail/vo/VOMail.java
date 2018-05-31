package com.kaltia.kaltiatransaccion.mail.vo;

import java.io.Serializable;

public class VOMail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3553332906586051747L;
	private String userOrigen;
	private String asunto;
	private String body;
	private String userDestino;
	private boolean status;
	private String mensaje;
	public String getUserOrigen() {
		return userOrigen;
	}
	public void setUserOrigen(String userOrigen) {
		this.userOrigen = userOrigen;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getUserDestino() {
		return userDestino;
	}
	public void setUserDestino(String userDestino) {
		this.userDestino = userDestino;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
