package com.kaltia.kaltiatransaccion.Edicion.VO;

import java.io.Serializable;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ResultDAOVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String message;
	private String code;
	private String properties;
	private boolean logic;
	private int num;
	private JSONObject json;
	private List<JSONObject> arrayJson;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	public boolean isLogic() {
		return logic;
	}
	public void setLogic(boolean logic) {
		this.logic = logic;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public JSONObject getJson() {
		return json;
	}
	public void setJson(JSONObject json) {
		this.json = json;
	}
	public List<JSONObject> getArrayJson() {
		return arrayJson;
	}
	public void setArrayJson(List<JSONObject> arrayJson) {
		this.arrayJson = arrayJson;
	}
	
	
	
	
	
	

}
