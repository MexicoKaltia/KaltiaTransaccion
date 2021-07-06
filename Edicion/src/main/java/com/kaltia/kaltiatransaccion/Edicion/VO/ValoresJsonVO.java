package com.kaltia.kaltiatransaccion.Edicion.VO;

import org.springframework.stereotype.Component;

@Component
public class ValoresJsonVO {
public ValoresJsonVO() {}
	
	private String action;
	private String IdEmpresa;
	private String seccion;
	private String nombreCorto;
	private String valoresFinales;
	private String valoresAuxiliares;
	private String string;
	
	public ValoresJsonVO(String action, String idEmpresa, String seccion, String valoresFinales,
			String valoresAuxiliares, String string) {
		super();
		this.action = action;
		this.IdEmpresa = idEmpresa;
		this.seccion = seccion;
		this.valoresFinales = valoresFinales;
		this.valoresAuxiliares = valoresAuxiliares;
		this.string = string;
	}
	
	public ValoresJsonVO(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "ValoresJSONVO [action=" + action + ", IdEmpresa=" + IdEmpresa + ", seccion=" + seccion
				+ ", nombreCorto=" + nombreCorto + ", valoresFinales=" + valoresFinales + ", valoresAuxiliares="
				+ valoresAuxiliares + ", string=" + string + "]";
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	
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
	public String getValoresAuxiliares() {
		return valoresAuxiliares;
	}
	public void setValoresAuxiliares(String valoresAuxiliares) {
		this.valoresAuxiliares = valoresAuxiliares;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	
	

}
