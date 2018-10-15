package com.kaltia.kaltiatransaccion.Edicion.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Qualifier("empresaEntity")
//@NamedQueries({
//	@NamedQuery(query ="Select a from tc_empresa a where a.empresaIdPerfilE = :id", name = "find empresa by idEmpresa"),
//	@NamedQuery(query ="Select a from tc_empresa a where a.empresaIdPerfilI = :id", name = "find empresa by idEmpresaArray")
//})
@Entity
@Table(name="tc_empresa")
public class EmpresaEntity {
	
	public EmpresaEntity(){}

	
	@Id
	private String idEmpresa;
	@Column
	private String idAction;
	@Column
	private String empresaNombreCompleto;
	@Column
	private String empresaRFC;
	@Column
	private String empresaDireccion;
	@Column
	private String empresaEmail;
	@Column
	private String empresaContacto;
	@Column
	private String empresaIdPerfilI;
	@Column
	private String empresaVarios;
	@Column
	private String empresaIdPerfilE;
	@Column
	private String empresaModelo;
	@Column
	private String empresaStatus;
	@Column
	private String empresaFechaCorte;
	@Column
	private String empresaModoPago;
	@Column
	private String empresaFactura;
	
	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getIdAction() {
		return idAction;
	}

	public void setIdAction(String idAction) {
		this.idAction = idAction;
	}

	public String getEmpresaNombreCompleto() {
		return empresaNombreCompleto;
	}

	public void setEmpresaNombreCompleto(String empresaNombreCompleto) {
		this.empresaNombreCompleto = empresaNombreCompleto;
	}

	public String getEmpresaRFC() {
		return empresaRFC;
	}

	public void setEmpresaRFC(String empresaRFC) {
		this.empresaRFC = empresaRFC;
	}

	public String getEmpresaDireccion() {
		return empresaDireccion;
	}

	public void setEmpresaDireccion(String empresaDireccion) {
		this.empresaDireccion = empresaDireccion;
	}

	public String getEmpresaEmail() {
		return empresaEmail;
	}

	public void setEmpresaEmail(String empresaEmail) {
		this.empresaEmail = empresaEmail;
	}

	public String getEmpresaContacto() {
		return empresaContacto;
	}

	public void setEmpresaContacto(String empresaContacto) {
		this.empresaContacto = empresaContacto;
	}

	public String getEmpresaIdPerfilI() {
		return empresaIdPerfilI;
	}

	public void setEmpresaIdPerfilI(String empresaIdPerfilI) {
		this.empresaIdPerfilI = empresaIdPerfilI;
	}

	public String getEmpresaVarios() {
		return empresaVarios;
	}

	public void setEmpresaVarios(String empresaVarios) {
		this.empresaVarios = empresaVarios;
	}

	public String getEmpresaIdPerfilE() {
		return empresaIdPerfilE;
	}

	public void setEmpresaIdPerfilE(String empresaIdPerfilE) {
		this.empresaIdPerfilE = empresaIdPerfilE;
	}

	public String getEmpresaModelo() {
		return empresaModelo;
	}

	public void setEmpresaModelo(String empresaModelo) {
		this.empresaModelo = empresaModelo;
	}

	public String getEmpresaStatus() {
		return empresaStatus;
	}

	public void setEmpresaStatus(String empresaStatus) {
		this.empresaStatus = empresaStatus;
	}

	public String getEmpresaFechaCorte() {
		return empresaFechaCorte;
	}

	public void setEmpresaFechaCorte(String empresaFechaCorte) {
		this.empresaFechaCorte = empresaFechaCorte;
	}

	public String getEmpresaModoPago() {
		return empresaModoPago;
	}

	public void setEmpresaModoPago(String empresaModoPago) {
		this.empresaModoPago = empresaModoPago;
	}

	public String getEmpresaFactura() {
		return empresaFactura;
	}

	public void setEmpresaFactura(String empresaFactura) {
		this.empresaFactura = empresaFactura;
	}



}
