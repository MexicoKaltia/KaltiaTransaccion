package com.kaltia.kaltiatransaccion.Edicion.Service;

import java.io.Serializable;

import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

public interface CitaEmpresaService extends Serializable{
	
	public ResultVO citaEmpresaServiceCreate(String action, String horario) throws Exception;	
	public ResultVO citaEmpresaServiceRead(String action);
	public ResultVO citaEmpresaServiceUpdate(ValoresJsonVO valoresJsonVO);
	public ResultVO citaEmpresaServiceDelete();
}