package com.kaltia.kaltiatransaccion.Edicion.VO;


import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

@Entity
@Table(name="tw_citaempresa")
public class CitaEmpresaEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8080900534465775443L;


	public CitaEmpresaEntity(){}
	
	@Id
	private String idAction;
	@Column
	private String condiciones;
	@Column
	private String citaEnero;
	@Column            
	private String citaFebrero;
	@Column            
	private String citaMarzo;
	@Column            
	private String citaAbril;
	@Column            
	private String citaMayo;
	@Column
	private String citaJunio;
	@Column
	private String citaJulio;
	@Column
	private String citaAgosto;
	@Column
	private String citaSeptiembre;
	@Column
	private String citaOctubre;
	@Column
	private String citaNoviembre;
	@Column
	private String citaDiciembre;
	
	
	public String getIdAction() {
		return idAction;
	}
	public void setIdAction(String idAction) {
		this.idAction = idAction;
	}
	public String getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}
	public String getCitaEnero() {
		return citaEnero;
	}
	public void setCitaEnero(String citaEnero) {
		this.citaEnero = citaEnero;
	}
	public String getCitaFebrero() {
		return citaFebrero;
	}
	public void setCitaFebrero(String citaFebrero) {
		this.citaFebrero = citaFebrero;
	}
	public String getCitaMarzo() {
		return citaMarzo;
	}
	public void setCitaMarzo(String citaMarzo) {
		this.citaMarzo = citaMarzo;
	}
	public String getCitaAbril() {
		return citaAbril;
	}
	public void setCitaAbril(String citaAbril) {
		this.citaAbril = citaAbril;
	}
	public String getCitaMayo() {
		return citaMayo;
	}
	public void setCitaMayo(String citaMayo) {
		this.citaMayo = citaMayo;
	}
	public String getCitaJunio() {
		return citaJunio;
	}
	public void setCitaJunio(String citaJunio) {
		this.citaJunio = citaJunio;
	}
	public String getCitaJulio() {
		return citaJulio;
	}
	public void setCitaJulio(String citaJulio) {
		this.citaJulio = citaJulio;
	}
	public String getCitaAgosto() {
		return citaAgosto;
	}
	public void setCitaAgosto(String citaAgosto) {
		this.citaAgosto = citaAgosto;
	}
	public String getCitaSeptiembre() {
		return citaSeptiembre;
	}
	public void setCitaSeptiembre(String citaSeptiembre) {
		this.citaSeptiembre = citaSeptiembre;
	}
	public String getCitaOctubre() {
		return citaOctubre;
	}
	public void setCitaOctubre(String citaOctubre) {
		this.citaOctubre = citaOctubre;
	}
	public String getCitaNoviembre() {
		return citaNoviembre;
	}
	public void setCitaNoviembre(String citaNoviembre) {
		this.citaNoviembre = citaNoviembre;
	}
	public String getCitaDiciembre() {
		return citaDiciembre;
	}
	public void setCitaDiciembre(String citaDiciembre) {
		this.citaDiciembre = citaDiciembre;
	}
	
	
	
}

	
//	@Id
//	private String idAction;
//	@Column
//	private ArrayList<JSONObject> condiciones;
//	@Column
//	private ArrayList<JSONObject> citaEnero;
//	@Column            
//	private ArrayList<JSONObject> citaFebrero;
//	@Column            
//	private ArrayList<JSONObject> citaMarzo;
//	@Column            
//	private ArrayList<JSONObject> citaAbril;
//	@Column            
//	private ArrayList<JSONObject> citaMayo;
//	@Column
//	private ArrayList<JSONObject> citaJunio;
//	@Column
//	private ArrayList<JSONObject> citaJulio;
//	@Column
//	private ArrayList<JSONObject> citaAgosto;
//	@Column
//	private ArrayList<JSONObject> citaSeptiembre;
//	@Column
//	private ArrayList<JSONObject> citaOctubre;
//	@Column
//	private ArrayList<JSONObject> citaNoviembre;
//	@Column
//	private ArrayList<JSONObject> citaDiciembre;
//	
//	
//	public String getIdAction() {
//		return idAction;
//	}
//	public void setIdAction(String idAction) {
//		this.idAction = idAction;
//	}
//	public ArrayList<JSONObject> getCondiciones() {
//		return condiciones;
//	}
//	public void setCondiciones(ArrayList<JSONObject> condiciones) {
//		this.condiciones = condiciones;
//	}
//	public ArrayList<JSONObject> getCitaEnero() {
//		return citaEnero;
//	}
//	public void setCitaEnero(ArrayList<JSONObject> citaEnero) {
//		this.citaEnero = citaEnero;
//	}
//	public ArrayList<JSONObject> getCitaFebrero() {
//		return citaFebrero;
//	}
//	public void setCitaFebrero(ArrayList<JSONObject> citaFebrero) {
//		this.citaFebrero = citaFebrero;
//	}
//	public ArrayList<JSONObject> getCitaMarzo() {
//		return citaMarzo;
//	}
//	public void setCitaMarzo(ArrayList<JSONObject> citaMarzo) {
//		this.citaMarzo = citaMarzo;
//	}
//	public ArrayList<JSONObject> getCitaAbril() {
//		return citaAbril;
//	}
//	public void setCitaAbril(ArrayList<JSONObject> citaAbril) {
//		this.citaAbril = citaAbril;
//	}
//	public ArrayList<JSONObject> getCitaMayo() {
//		return citaMayo;
//	}
//	public void setCitaMayo(ArrayList<JSONObject> citaMayo) {
//		this.citaMayo = citaMayo;
//	}
//	public ArrayList<JSONObject> getCitaJunio() {
//		return citaJunio;
//	}
//	public void setCitaJunio(ArrayList<JSONObject> citaJunio) {
//		this.citaJunio = citaJunio;
//	}
//	public ArrayList<JSONObject> getCitaJulio() {
//		return citaJulio;
//	}
//	public void setCitaJulio(ArrayList<JSONObject> citaJulio) {
//		this.citaJulio = citaJulio;
//	}
//	public ArrayList<JSONObject> getCitaAgosto() {
//		return citaAgosto;
//	}
//	public void setCitaAgosto(ArrayList<JSONObject> citaAgosto) {
//		this.citaAgosto = citaAgosto;
//	}
//	public ArrayList<JSONObject> getCitaSeptiembre() {
//		return citaSeptiembre;
//	}
//	public void setCitaSeptiembre(ArrayList<JSONObject> citaSeptiembre) {
//		this.citaSeptiembre = citaSeptiembre;
//	}
//	public ArrayList<JSONObject> getCitaOctubre() {
//		return citaOctubre;
//	}
//	public void setCitaOctubre(ArrayList<JSONObject> citaOctubre) {
//		this.citaOctubre = citaOctubre;
//	}
//	public ArrayList<JSONObject> getCitaNoviembre() {
//		return citaNoviembre;
//	}
//	public void setCitaNoviembre(ArrayList<JSONObject> citaNoviembre) {
//		this.citaNoviembre = citaNoviembre;
//	}
//	public ArrayList<JSONObject> getCitaDiciembre() {
//		return citaDiciembre;
//	}
//	public void setCitaDiciembre(ArrayList<JSONObject> citaDiciembre) {
//		this.citaDiciembre = citaDiciembre;
//	}
//	
//	
//	
//}
