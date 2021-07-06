package com.kaltia.kaltiatransaccion.Edicion.Service;

import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.UserEmpresaEntity;

public interface ClienteRest {
	
	public ResultVO notificarKUENuevo(UserEmpresaEntity userEmpresaEntity, String nombreCorto);

}
