package com.kaltia.kaltiatransaccion.Edicion.VO;

import java.io.Serializable;


public class VOStatus implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1193166547440566111L;
	
	public VOStatus(Integer codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	
	private Integer codigo;
	private String	mensaje;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
