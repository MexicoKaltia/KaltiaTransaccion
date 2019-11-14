package com.kaltia.kaltiatransaccion.Edicion.VO;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.simple.JSONObject;
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
	
	private Integer codigo;
	private String	mensaje;
	private ArrayList<String> mensajeArray;
	private String  response;
	private JSONObject jsonResponse;
	private ArrayList<JSONObject> jsonResponseArray;
	
	public ResultVO(Integer codigo, String mensaje, ArrayList<String> mensajeArray, String response,
			JSONObject jsonResponse, ArrayList<JSONObject> jsonResponseArray) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.mensajeArray = mensajeArray;
		this.response = response;
		this.jsonResponse = jsonResponse;
		this.jsonResponseArray = jsonResponseArray;
	}
	
	
	
	@Override
	public String toString() {
		return "ResultVO [codigo=" + codigo + ", mensaje=" + mensaje + ", mensajeArray=" + mensajeArray + ", response="
				+ response + ", jsonResponse=" + jsonResponse + ", jsonResponseArray=" + jsonResponseArray + "]";
	}



	public ArrayList<JSONObject> getJsonResponseArray() {
		return jsonResponseArray;
	}
	public void setJsonResponseArray(ArrayList<JSONObject> jsonResponseArray) {
		this.jsonResponseArray = jsonResponseArray;
	}
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
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public JSONObject getJsonResponse() {
		return jsonResponse;
	}
	public void setJsonResponse(JSONObject jsonResponse) {
		this.jsonResponse = jsonResponse;
	}
	
	public ArrayList<String> getMensajeArray() {
		return mensajeArray;
	}
	public void setMensajeArray(ArrayList<String> mensajeArray) {
		this.mensajeArray = mensajeArray;
	}


	
	

}
