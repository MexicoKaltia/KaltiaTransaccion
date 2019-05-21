package com.kaltia.kaltiatransaccion.Edicion.Service;

import java.io.Serializable;

import com.kaltia.kaltiatransaccion.Edicion.VO.EmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

public interface EmpresaService extends Serializable{

	public ResultVO empresaServiceCreate(ValoresJsonVO valoresJsonVO);
	public EmpresaEntity empresaServiceRead(String idEmpresa);
	public ResultVO empresaServiceUpdate(EmpresaEntity empresaEntity);
	public ResultVO empresaServiceDelete(String idEmpresa);

}
