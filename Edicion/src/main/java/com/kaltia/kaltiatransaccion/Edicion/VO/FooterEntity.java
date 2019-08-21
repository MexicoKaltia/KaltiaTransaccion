package com.kaltia.kaltiatransaccion.Edicion.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tw_footer")
public class FooterEntity {

	public FooterEntity() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	private String idFooter;// varchar(45) PK 
	@Column
	private String idEmpresa ;
	@Column
	private String footerSeccion1 ;
	@Column
	private String footerSeccion2 ;
	@Column
	private String footerSeccion3 ;
	@Column
	private String footerSeccion4 ;
	@Column
	private String footerSeccion5 ;
	@Column
	private String footerSeccionArray1 ;
	@Column
	private String footerSeccionArray2 ;
	@Column
	private String footerAux1 ;
	@Column
	private String footerAux2 ;
	@Column
	private String footerVarios ;
	@Column
	private String footerSecciones ;
	@Column
	private String footerSeccionUbicacion ;
	@Column
	private String footerSeccionRedes ;
	
	
	
	
	
	

	
	
	public String getIdFooter() {
		return idFooter;
	}
	public void setIdFooter(String idFooter) {
		this.idFooter = idFooter;
	}
	public String getFooterSecciones() {
		return footerSecciones;
	}
	public void setFooterSecciones(String footerSecciones) {
		this.footerSecciones = footerSecciones;
	}
	public String getFooterSeccionUbicacion() {
		return footerSeccionUbicacion;
	}
	public void setFooterSeccionUbicacion(String footerSeccionUbicacion) {
		this.footerSeccionUbicacion = footerSeccionUbicacion;
	}
	public String getFooterSeccionRedes() {
		return footerSeccionRedes;
	}
	public void setFooterSeccionRedes(String footerSeccionRedes) {
		this.footerSeccionRedes = footerSeccionRedes;
	}
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getFooterSeccion1() {
		return footerSeccion1;
	}
	public void setFooterSeccion1(String footerSeccion1) {
		this.footerSeccion1 = footerSeccion1;
	}
	public String getFooterSeccion2() {
		return footerSeccion2;
	}
	public void setFooterSeccion2(String footerSeccion2) {
		this.footerSeccion2 = footerSeccion2;
	}
	public String getFooterSeccion3() {
		return footerSeccion3;
	}
	public void setFooterSeccion3(String footerSeccion3) {
		this.footerSeccion3 = footerSeccion3;
	}
	public String getFooterSeccion4() {
		return footerSeccion4;
	}
	public void setFooterSeccion4(String footerSeccion4) {
		this.footerSeccion4 = footerSeccion4;
	}
	public String getFooterSeccion5() {
		return footerSeccion5;
	}
	public void setFooterSeccion5(String footerSeccion5) {
		this.footerSeccion5 = footerSeccion5;
	}
	public String getFooterSeccionArray1() {
		return footerSeccionArray1;
	}
	public void setFooterSeccionArray1(String footerSeccionArray1) {
		this.footerSeccionArray1 = footerSeccionArray1;
	}
	public String getFooterSeccionArray2() {
		return footerSeccionArray2;
	}
	public void setFooterSeccionArray2(String footerSeccionArray2) {
		this.footerSeccionArray2 = footerSeccionArray2;
	}
	public String getFooterAux1() {
		return footerAux1;
	}
	public void setFooterAux1(String footerAux1) {
		this.footerAux1 = footerAux1;
	}
	public String getFooterAux2() {
		return footerAux2;
	}
	public void setFooterAux2(String footerAux2) {
		this.footerAux2 = footerAux2;
	}
	public String getFooterVarios() {
		return footerVarios;
	}
	public void setFooterVarios(String footerVarios) {
		this.footerVarios = footerVarios;
	}
	
	

}
