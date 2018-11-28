package com.kaltia.kaltiatransaccion.Edicion.Service;

import com.kaltia.kaltiatransaccion.Edicion.VO.ResultArrayVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

public interface UserEmpresaService {
	
	public ResultVO userEmpresaCreate(ValoresJsonVO valoresJsonVO);
	public ResultArrayVO userEmpresaRead(ValoresJsonVO valoresJsonVO);
	public ResultVO userEmpresaUpdate(ValoresJsonVO valoresJsonVO);
	public ResultVO userEmpresaDelete(ValoresJsonVO valoresJsonVO);


}
