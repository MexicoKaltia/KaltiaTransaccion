package com.kaltia.kaltiatransaccion.Edicion.Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiatransaccion.Edicion.DAO.EmpresaDAO;
import com.kaltia.kaltiatransaccion.Edicion.VO.EmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	@Qualifier("empresaDAO")
	private EmpresaDAO empresaDAO;


	@Override
	public ResultVO empresaServiceCreate(EmpresaEntity empresaEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpresaEntity empresaServiceRead(String idEmpresa) {
		EmpresaEntity empresaEntity = new EmpresaEntity();
		try {
			empresaEntity = empresaDAO.findOne(idEmpresa);
		}catch(Exception e) {
			empresaEntity.setEmpresaStatus(e.toString());
		}				
		
		return empresaEntity;
	}

	@Override
	public ResultVO empresaServiceUpdate(EmpresaEntity empresaEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultVO empresaServiceDelete(String idEmpresa) {
		// TODO Auto-generated method stub
		return null;
	}

}
