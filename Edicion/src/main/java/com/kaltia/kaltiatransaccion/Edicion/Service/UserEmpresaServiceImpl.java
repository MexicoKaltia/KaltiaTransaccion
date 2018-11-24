package com.kaltia.kaltiatransaccion.Edicion.Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiatransaccion.Edicion.DAO.UserEmpresaDAO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.UserEmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

@Service("userEmpresaServiceImpl")
public class UserEmpresaServiceImpl implements UserEmpresaService {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
@Autowired
private ResultVO resultVO;

@Autowired
@Qualifier("userEmpresaDAO")
private UserEmpresaDAO userEmpresaDAO;

@Autowired
private CitaServiceImpl citaServiceImpl;



	@Override
	public ResultVO userEmpresaCreate(ValoresJsonVO valoresJsonVO) {
		UserEmpresaEntity userEmpresaEntity = new UserEmpresaEntity();
		logger.info(valoresJsonVO.getValoresFinales());
		String[] valoresRegistro = valoresJsonVO.getValoresFinales().split("\\++");
		
		userEmpresaEntity.setIdUserEmpresa(valoresJsonVO.getAction()+valoresRegistro[4]);
		userEmpresaEntity.setActionRegistro(valoresJsonVO.getAction());
		userEmpresaEntity.setNombreRegistro(valoresRegistro[0]);
		userEmpresaEntity.setApellidoRegistro(valoresRegistro[1]);
		userEmpresaEntity.setEmailRegistro(valoresRegistro[2]);
		userEmpresaEntity.setTelefonoRegistro(valoresRegistro[3]);
		userEmpresaEntity.setUsuarioRegistro(valoresRegistro[4]);
		userEmpresaEntity.setPassRegistro(valoresRegistro[5]);
		userEmpresaEntity.setMessageRegistro(valoresRegistro[6]);
		
		userEmpresaDAO.save(userEmpresaEntity);
		
		resultVO.setCodigo(0);
		resultVO.setMensaje("Create UserEmpresa Exito");
		
		return resultVO;//.empresaCreateDAO(empresaEntity);


	}

	@Override
	public ResultVO userEmpresaRead(ValoresJsonVO valoresJsonVO) {
		String[] valoresRegistro = valoresJsonVO.getValoresFinales().split("\\++");
		logger.info(valoresJsonVO.getValoresFinales());
		UserEmpresaEntity userEmpresaEntity = new UserEmpresaEntity();
		try {
			userEmpresaEntity = userEmpresaDAO.findOne(valoresJsonVO.getAction()+valoresRegistro[0]);
			if(userEmpresaEntity.getPassRegistro().equals(valoresRegistro[1])) {
				userEmpresaEntity.setMonitorRegistro(valoresRegistro[2]);
				userEmpresaDAO.save(userEmpresaEntity);
				
				citaServiceImpl.citaServiceRead(valoresJsonVO.getAction());
				
				resultVO.setCodigo(0);
				resultVO.setMensaje(userEmpresaEntity.getIdUserEmpresa()+"++"+userEmpresaEntity.getNombreRegistro());
			}else {
				resultVO.setCodigo(99);
				resultVO.setMensaje("Usuario > Password inválidos");
			}
		}catch(Exception e) {
			resultVO.setCodigo(99);
			resultVO.setMensaje("Usuario < Password inválidos");
		}				
		
		return resultVO;//.empresaCreateDAO(empresaEntity);
	}

	@Override
	public ResultVO userEmpresaUpdate(ValoresJsonVO valoresJsonVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultVO userEmpresaDelete(ValoresJsonVO valoresJsonVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
