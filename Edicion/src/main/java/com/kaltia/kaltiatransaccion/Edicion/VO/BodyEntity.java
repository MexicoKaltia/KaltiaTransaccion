package com.kaltia.kaltiatransaccion.Edicion.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tw_body")
public class BodyEntity {
	
	public BodyEntity() {}
	
	@Id
	private String idBody;
	@Column
	private String idEmpresa ;
	@Column
	private String bodyFondo ;
	@Column
	private String bodySeccion1 ;
	@Column
	private String bodySeccion2 ;
	@Column
	private String bodySeccion3 ;
	@Column
	private String bodySeccion4 ;
	@Column
	private String bodySeccion5 ;
	@Column
	private String bodySeccion6 ;
	@Column
	private String bodySeccion7 ;
	@Column
	private String bodySeccion8 ;
	@Column
	private String bodyQRE ;
	@Column
	private String bodyQRD;
	@Column
	private String bodySeccionArray1 ;
	@Column
	private String bodySeccionArray2 ;
	@Column
	private String bodySeccionArray3 ;
	@Column
	private String bodySeccionArray4 ;
	@Column
	private String bodySeccionArray5 ;
	@Column
	private String bodySeccionArray6 ;
	@Column
	private String bodySeccionArray7 ;
	
	
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getBodyFondo() {
		return bodyFondo;
	}
	public void setBodyFondo(String bodyFondo) {
		this.bodyFondo = bodyFondo;
	}
	public String getBodySeccion1() {
		return bodySeccion1;
	}
	public void setBodySeccion1(String bodySeccion1) {
		this.bodySeccion1 = bodySeccion1;
	}
	public String getBodySeccion2() {
		return bodySeccion2;
	}
	public void setBodySeccion2(String bodySeccion2) {
		this.bodySeccion2 = bodySeccion2;
	}
	public String getBodySeccion3() {
		return bodySeccion3;
	}
	public void setBodySeccion3(String bodySeccion3) {
		this.bodySeccion3 = bodySeccion3;
	}
	public String getBodySeccion4() {
		return bodySeccion4;
	}
	public void setBodySeccion4(String bodySeccion4) {
		this.bodySeccion4 = bodySeccion4;
	}
	public String getBodySeccion5() {
		return bodySeccion5;
	}
	public void setBodySeccion5(String bodySeccion5) {
		this.bodySeccion5 = bodySeccion5;
	}
	public String getBodySeccion6() {
		return bodySeccion6;
	}
	public void setBodySeccion6(String bodySeccion6) {
		this.bodySeccion6 = bodySeccion6;
	}
	public String getBodySeccion7() {
		return bodySeccion7;
	}
	public void setBodySeccion7(String bodySeccion7) {
		this.bodySeccion7 = bodySeccion7;
	}
	public String getBodySeccion8() {
		return bodySeccion8;
	}
	public void setBodySeccion8(String bodySeccion8) {
		this.bodySeccion8 = bodySeccion8;
	}
	public String getIdBody() {
		return idBody;
	}
	public void setIdBody(String idBody) {
		this.idBody = idBody;
	}
	public String getBodySeccionArray1() {
		return bodySeccionArray1;
	}
	public void setBodySeccionArray1(String bodySeccionArray1) {
		this.bodySeccionArray1 = bodySeccionArray1;
	}
	public String getBodySeccionArray2() {
		return bodySeccionArray2;
	}
	public void setBodySeccionArray2(String bodySeccionArray2) {
		this.bodySeccionArray2 = bodySeccionArray2;
	}
	public String getBodySeccionArray3() {
		return bodySeccionArray3;
	}
	public void setBodySeccionArray3(String bodySeccionArray3) {
		this.bodySeccionArray3 = bodySeccionArray3;
	}
	public String getBodySeccionArray4() {
		return bodySeccionArray4;
	}
	public void setBodySeccionArray4(String bodySeccionArray4) {
		this.bodySeccionArray4 = bodySeccionArray4;
	}
	public String getBodySeccionArray5() {
		return bodySeccionArray5;
	}
	public void setBodySeccionArray5(String bodySeccionArray5) {
		this.bodySeccionArray5 = bodySeccionArray5;
	}
	public String getBodySeccionArray6() {
		return bodySeccionArray6;
	}
	public void setBodySeccionArray6(String bodySeccionArray6) {
		this.bodySeccionArray6 = bodySeccionArray6;
	}
	public String getBodySeccionArray7() {
		return bodySeccionArray7;
	}
	public void setBodySeccionArray7(String bodySeccionArray7) {
		this.bodySeccionArray7 = bodySeccionArray7;
	}
	public String getBodyQRE() {
		return bodyQRE;
	}
	public void setBodyQRE(String bodyQRE) {
		this.bodyQRE = bodyQRE;
	}
	public String getBodyQRD() {
		return bodyQRD;
	}
	public void setBodyQRD(String bodyQRD) {
		this.bodyQRD = bodyQRD;
	}


	

}
