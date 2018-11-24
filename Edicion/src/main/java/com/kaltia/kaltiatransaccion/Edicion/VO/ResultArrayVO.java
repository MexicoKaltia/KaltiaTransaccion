package com.kaltia.kaltiatransaccion.Edicion.VO;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ResultArrayVO implements Serializable{
	
	public ResultArrayVO() {};
	
	private Integer codigo;
	private ArrayList<String> mensaje;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public ArrayList<String> getMensaje() {
		return mensaje;
	}
	public void setMensaje(ArrayList<String> mensaje) {
		this.mensaje = mensaje;
	}
	
	
	


}
