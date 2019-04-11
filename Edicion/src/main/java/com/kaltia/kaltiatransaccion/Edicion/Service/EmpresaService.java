package com.kaltia.kaltiatransaccion.Edicion.Service;

import java.io.Serializable;

import com.kaltia.kaltiatransaccion.Edicion.VO.EmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;

public interface EmpresaService extends Serializable{

	public ResultVO empresaServiceCreate(String idAction);
	public EmpresaEntity empresaServiceRead(String idEmpresa);
	public ResultVO empresaServiceUpdate(EmpresaEntity empresaEntity);
	public ResultVO empresaServiceDelete(String idEmpresa);

}
