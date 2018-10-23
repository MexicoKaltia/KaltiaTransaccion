package com.kaltia.kaltiatransaccion.FileUpload.VO;

import java.io.Serializable;
import java.lang.Integer;
import org.springframework.stereotype.Component;

@Component
public class ResultVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1193166547440566111L;
	
//	public ResultVO(Integer codigo, String mensaje) {
//		this.codigo = codigo;
//		this.mensaje = mensaje;
//	}

	public ResultVO() {}
	
	private String codigo;
	private String	mensaje;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
