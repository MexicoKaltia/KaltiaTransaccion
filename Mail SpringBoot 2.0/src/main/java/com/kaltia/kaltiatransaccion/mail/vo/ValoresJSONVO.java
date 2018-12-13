package com.kaltia.kaltiatransaccion.mail.vo;

import org.springframework.stereotype.Component;

@Component
public class ValoresJSONVO {
	
	public ValoresJSONVO() {}
	
	private String action;
	private String IdEmpresa;
	private String seccion;
	private String valoresFinales;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getIdEmpresa() {
		return IdEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		IdEmpresa = idEmpresa;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getValoresFinales() {
		return valoresFinales;
	}
	public void setValoresFinales(String valoresFinales) {
		this.valoresFinales = valoresFinales;
	}
	
	

}
