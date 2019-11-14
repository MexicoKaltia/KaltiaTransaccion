package com.kaltia.kaltiatransaccion.Edicion.Service;

import java.util.List;

import com.kaltia.kaltiatransaccion.Edicion.VO.ResultArrayVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.UserEmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

public interface UserEmpresaService {
	
	public ResultVO userEmpresaCreate(ValoresJsonVO valoresJsonVO);
	//public ResultVO userEmpresaCreate(String idUserEmpresa);
	public ResultVO userEmpresaRead(ValoresJsonVO valoresJsonVO);
	public List<UserEmpresaEntity> userEmpresaReadList(String idAction, String userEmpresaAction);
//	public UserEmpresaEntity userEmpresaRead(String idUserEmpresa);
	public ResultVO userEmpresaUpdate(String idUserEmpresa);
	public ResultVO userEmpresaDelete(String idUserEmpresa);


}
