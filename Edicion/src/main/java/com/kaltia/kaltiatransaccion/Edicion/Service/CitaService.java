package com.kaltia.kaltiatransaccion.Edicion.Service;

import java.io.Serializable;

import com.kaltia.kaltiatransaccion.Edicion.VO.ResultArrayVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

public interface CitaService extends Serializable{
	
	public ResultVO citaServiceCreate(ValoresJsonVO valoresJsonVO) throws Exception;
	
	public ResultVO citaServiceRead(String action);
	public ResultVO citaServiceUpdate(ValoresJsonVO valoresJsonVO);
	public ResultVO citaServiceDelete();

	

}
