package com.kaltia.kaltiatransaccion.Edicion.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tw_header")
public class HeaderEntity {
	
	public HeaderEntity(){}
	
	@Id
	private String idHeader; //varchar(45) PK 
	@Column
	private String idEmpresa ;
	@Column
	private String headerSeccionArray1 ;
	@Column
	private String headerSeccionArray2 ;
	@Column
	private String headerSeccionArray3 ;
	@Column
	private String headerSeccionArray4 ;
	@Column
	private String headerSeccionArray5 ;
	@Column
	private String headerSeccion1 ;
	@Column
	private String headerSeccion2 ;
	@Column
	private String headerSeccion3 ;
	@Column
	private String headerSeccion4 ;
	@Column
	private String headerSeccion5 ;
	@Column
	private String headerAux1 ;
	@Column
	private String headerAux2 ;
	@Column
	private String headerAux3 ;
	@Column
	private String headerAux4 ;
	@Column
	private String headerAux5 ;
	@Column
	private String headerVarios ;
	public String getIdHeader() {
		return idHeader;
	}
	public void setIdHeader(String idHeader) {
		this.idHeader = idHeader;
	}
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getHeaderSeccionArray1() {
		return headerSeccionArray1;
	}
	public void setHeaderSeccionArray1(String headerSeccionArray1) {
		this.headerSeccionArray1 = headerSeccionArray1;
	}
	public String getHeaderSeccionArray2() {
		return headerSeccionArray2;
	}
	public void setHeaderSeccionArray2(String headerSeccionArray2) {
		this.headerSeccionArray2 = headerSeccionArray2;
	}
	public String getHeaderSeccionArray3() {
		return headerSeccionArray3;
	}
	public void setHeaderSeccionArray3(String headerSeccionArray3) {
		this.headerSeccionArray3 = headerSeccionArray3;
	}
	public String getHeaderSeccionArray4() {
		return headerSeccionArray4;
	}
	public void setHeaderSeccionArray4(String headerSeccionArray4) {
		this.headerSeccionArray4 = headerSeccionArray4;
	}
	public String getHeaderSeccionArray5() {
		return headerSeccionArray5;
	}
	public void setHeaderSeccionArray5(String headerSeccionArray5) {
		this.headerSeccionArray5 = headerSeccionArray5;
	}
	public String getHeaderSeccion1() {
		return headerSeccion1;
	}
	public void setHeaderSeccion1(String headerSeccion1) {
		this.headerSeccion1 = headerSeccion1;
	}
	public String getHeaderSeccion2() {
		return headerSeccion2;
	}
	public void setHeaderSeccion2(String headerSeccion2) {
		this.headerSeccion2 = headerSeccion2;
	}
	public String getHeaderSeccion3() {
		return headerSeccion3;
	}
	public void setHeaderSeccion3(String headerSeccion3) {
		this.headerSeccion3 = headerSeccion3;
	}
	public String getHeaderSeccion4() {
		return headerSeccion4;
	}
	public void setHeaderSeccion4(String headerSeccion4) {
		this.headerSeccion4 = headerSeccion4;
	}
	public String getHeaderSeccion5() {
		return headerSeccion5;
	}
	public void setHeaderSeccion5(String headerSeccion5) {
		this.headerSeccion5 = headerSeccion5;
	}
	public String getHeaderAux1() {
		return headerAux1;
	}
	public void setHeaderAux1(String headerAux1) {
		this.headerAux1 = headerAux1;
	}
	public String getHeaderAux2() {
		return headerAux2;
	}
	public void setHeaderAux2(String headerAux2) {
		this.headerAux2 = headerAux2;
	}
	public String getHeaderAux3() {
		return headerAux3;
	}
	public void setHeaderAux3(String headerAux3) {
		this.headerAux3 = headerAux3;
	}
	public String getHeaderAux4() {
		return headerAux4;
	}
	public void setHeaderAux4(String headerAux4) {
		this.headerAux4 = headerAux4;
	}
	public String getHeaderAux5() {
		return headerAux5;
	}
	public void setHeaderAux5(String headerAux5) {
		this.headerAux5 = headerAux5;
	}
	public String getHeaderVarios() {
		return headerVarios;
	}
	public void setHeaderVarios(String headerVarios) {
		this.headerVarios = headerVarios;
	}
	
	



}
