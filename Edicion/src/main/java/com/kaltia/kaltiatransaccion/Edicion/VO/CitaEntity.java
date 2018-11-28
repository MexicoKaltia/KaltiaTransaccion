package com.kaltia.kaltiatransaccion.Edicion.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tw_cita")
public class CitaEntity {
	
	public CitaEntity(){}
	
	@Id
	private String idAction;
	@Column
	private String condicionesCita;
	@Column
	private String eneroCita;
	@Column
	private String febreroCita;
	@Column
	private String marzoCita;
	@Column
	private String abrilCita;
	@Column
	private String mayoCita;
	@Column
	private String junioCita;
	@Column
	private String julioCita;
	@Column
	private String agostoCita;
	@Column
	private String septiembreCita;
	@Column
	private String octubreCita;
	@Column
	private String noviembreCita;
	@Column
	private String diciembreCita;
	
	
	public String getIdAction() {
		return idAction;
	}
	public void setIdAction(String idAction) {
		this.idAction = idAction;
	}
	public String getCondicionesCita() {
		return condicionesCita;
	}
	public void setCondicionesCita(String condicionesCita) {
		this.condicionesCita = condicionesCita;
	}
	public String getEneroCita() {
		return eneroCita;
	}
	public void setEneroCita(String eneroCita) {
		this.eneroCita = eneroCita;
	}
	public String getFebreroCita() {
		return febreroCita;
	}
	public void setFebreroCita(String febreroCita) {
		this.febreroCita = febreroCita;
	}
	public String getMarzoCita() {
		return marzoCita;
	}
	public void setMarzoCita(String marzoCita) {
		this.marzoCita = marzoCita;
	}
	public String getAbrilCita() {
		return abrilCita;
	}
	public void setAbrilCita(String abrilCita) {
		this.abrilCita = abrilCita;
	}
	public String getMayoCita() {
		return mayoCita;
	}
	public void setMayoCita(String mayoCita) {
		this.mayoCita = mayoCita;
	}
	public String getJunioCita() {
		return junioCita;
	}
	public void setJunioCita(String junioCita) {
		this.junioCita = junioCita;
	}
	public String getJulioCita() {
		return julioCita;
	}
	public void setJulioCita(String julioCita) {
		this.julioCita = julioCita;
	}
	public String getAgostoCita() {
		return agostoCita;
	}
	public void setAgostoCita(String agostoCita) {
		this.agostoCita = agostoCita;
	}
	public String getSeptiembreCita() {
		return septiembreCita;
	}
	public void setSeptiembreCita(String septiembreCita) {
		this.septiembreCita = septiembreCita;
	}
	public String getOctubreCita() {
		return octubreCita;
	}
	public void setOctubreCita(String octubreCita) {
		this.octubreCita = octubreCita;
	}
	public String getNoviembreCita() {
		return noviembreCita;
	}
	public void setNoviembreCita(String noviembreCita) {
		this.noviembreCita = noviembreCita;
	}
	public String getDiciembreCita() {
		return diciembreCita;
	}
	public void setDiciembreCita(String diciembreCita) {
		this.diciembreCita = diciembreCita;
	}
	
	
	

}
