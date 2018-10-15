package com.kaltia.kaltiatransaccion.Edicion.Service;

import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

public interface EdicionService {
	
	public ResultVO edicionServiceCreate();
	public ResultVO edicionServiceRead();
	public ResultVO edicionServiceUpdate(ValoresJsonVO valoresJsonVO);
	public ResultVO edicionServiceDelete();

}
