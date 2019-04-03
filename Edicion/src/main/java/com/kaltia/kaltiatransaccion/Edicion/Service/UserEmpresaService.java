package com.kaltia.kaltiatransaccion.Edicion.Service;

import com.kaltia.kaltiatransaccion.Edicion.VO.ResultArrayVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.UserEmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

public interface UserEmpresaService {
	
	public ResultVO userEmpresaCreate(ValoresJsonVO valoresJsonVO);
	//public ResultVO userEmpresaCreate(String idUserEmpresa);
	public ResultVO userEmpresaRead(ValoresJsonVO valoresJsonVO);
//	public UserEmpresaEntity userEmpresaRead(String idUserEmpresa);
	public ResultVO userEmpresaUpdate(String idUserEmpresa);
	public ResultVO userEmpresaDelete(ValoresJsonVO valoresJsonVO);


}
