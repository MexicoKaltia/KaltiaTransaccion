package com.kaltia.kaltiatransaccion.Edicion.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity(name="tc_productos")
@NamedQueries({
	@NamedQuery(query ="Select a from tc_productos a", name = "find Productos All"),
	@NamedQuery(query ="Select a from tc_productos a where a.idEmpresa= :id", name = "find Productos Id")
	
})
public class ProductosEntity {
	
		
	@Id
	private String idEmpresa;
	@Column
	private boolean checkPagina;
	@Column
	private boolean checkQRR;
	@Column
	private boolean checkQRE;
	@Column
	private boolean checkPuntoVenta;
	
	@Column
	private boolean clientePagina;
	@Column
	private boolean chatPagina;
	@Column
	private boolean videoPagina;
	@Column
	private boolean tarjetaPagina;
	@Column
	private boolean retroalimentacionPagina;
	
	@Column
	private boolean citaPagina;
	@Column
	private boolean carpetaPagina;
	@Column
	private boolean notificacionPagina;
	
	
	public ProductosEntity() {}

	public ProductosEntity(String idEmpresa, boolean checkPagina, boolean checkQRR, boolean checkQRE,
			boolean checkPuntoVenta, boolean clientePagina, boolean citaPagina, boolean carpetaPagina,
			boolean retroalimentacionPagina, boolean chatPagina, boolean notificacionPagina, boolean videoPagina,
			boolean tarjetaPagina) {
		super();
		this.idEmpresa = idEmpresa;
		this.checkPagina = checkPagina;
		this.checkQRR = checkQRR;
		this.checkQRE = checkQRE;
		this.checkPuntoVenta = checkPuntoVenta;
		this.clientePagina = clientePagina;
		this.citaPagina = citaPagina;
		this.carpetaPagina = carpetaPagina;
		this.retroalimentacionPagina = retroalimentacionPagina;
		this.chatPagina = chatPagina;
		this.notificacionPagina = notificacionPagina;
		this.videoPagina = videoPagina;
		this.tarjetaPagina = tarjetaPagina;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	
	public boolean isCheckPagina() {
		return checkPagina;
	}

	public void setCheckPagina(boolean checkPagina) {
		this.checkPagina = checkPagina;
	}

	public boolean isCheckQRR() {
		return checkQRR;
	}

	public void setCheckQRR(boolean checkQRR) {
		this.checkQRR = checkQRR;
	}

	public boolean isCheckQRE() {
		return checkQRE;
	}

	public void setCheckQRE(boolean checkQRE) {
		this.checkQRE = checkQRE;
	}

	public boolean isCheckPuntoVenta() {
		return checkPuntoVenta;
	}

	public void setCheckPuntoVenta(boolean checkPuntoVenta) {
		this.checkPuntoVenta = checkPuntoVenta;
	}

	public boolean isClientePagina() {
		return clientePagina;
	}

	public void setClientePagina(boolean clientePagina) {
		this.clientePagina = clientePagina;
	}

	public boolean isCitaPagina() {
		return citaPagina;
	}

	public void setCitaPagina(boolean citaPagina) {
		this.citaPagina = citaPagina;
	}

	public boolean isCarpetaPagina() {
		return carpetaPagina;
	}

	public void setCarpetaPagina(boolean carpetaPagina) {
		this.carpetaPagina = carpetaPagina;
	}

	public boolean isRetroalimentacionPagina() {
		return retroalimentacionPagina;
	}

	public void setRetroalimentacionPagina(boolean retroalimentacionPagina) {
		this.retroalimentacionPagina = retroalimentacionPagina;
	}

	public boolean isChatPagina() {
		return chatPagina;
	}

	public void setChatPagina(boolean chatPagina) {
		this.chatPagina = chatPagina;
	}

	public boolean isNotificacionPagina() {
		return notificacionPagina;
	}

	public void setNotificacionPagina(boolean notificacionPagina) {
		this.notificacionPagina = notificacionPagina;
	}

	public boolean isVideoPagina() {
		return videoPagina;
	}

	public void setVideoPagina(boolean videoPagina) {
		this.videoPagina = videoPagina;
	}

	public boolean isTarjetaPagina() {
		return tarjetaPagina;
	}

	public void setTarjetaPagina(boolean tarjetaPagina) {
		this.tarjetaPagina = tarjetaPagina;
	}

	@Override
	public String toString() {
		return "ProductosEntity [idEmpresa=" + idEmpresa + ", checkPagina=" + checkPagina + ", checkQRR=" + checkQRR
				+ ", checkQRE=" + checkQRE + ", checkPuntoVenta=" + checkPuntoVenta + ", clientePagina=" + clientePagina
				+ ", citaPagina=" + citaPagina + ", carpetaPagina=" + carpetaPagina + ", retroalimentacionPagina="
				+ retroalimentacionPagina + ", chatPagina=" + chatPagina + ", notificacionPagina=" + notificacionPagina
				+ ", videoPagina=" + videoPagina + ", tarjetaPagina=" + tarjetaPagina + "]";
	}
	
	
	
		
	

}
