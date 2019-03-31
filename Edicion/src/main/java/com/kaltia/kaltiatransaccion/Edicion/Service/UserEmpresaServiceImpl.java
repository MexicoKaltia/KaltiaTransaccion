package com.kaltia.kaltiatransaccion.Edicion.Service;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiatransaccion.Edicion.DAO.UserEmpresaDAO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultArrayVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.UserEmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

@Service("userEmpresaServiceImpl")
public class UserEmpresaServiceImpl implements UserEmpresaService {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
@Autowired
private ResultVO resultVO;
@Autowired
private ResultArrayVO resultArrayVO;
@Autowired
private CitaServiceImpl citaServiceImpl;
@Autowired
private ClienteRestImpl clienteRestImpl;

@Autowired
@Qualifier("userEmpresaDAO")
private UserEmpresaDAO userEmpresaDAO;




	@Override
	public ResultVO userEmpresaCreate(ValoresJsonVO valoresJsonVO) {
		UserEmpresaEntity userEmpresaEntity = new UserEmpresaEntity();
		logger.info(valoresJsonVO.getValoresFinales());
		try {
			if(valoresJsonVO.getValoresFinales()!= null && !valoresJsonVO.getValoresFinales().equals("")) {
				
				String[] valoresRegistro = valoresJsonVO.getValoresFinales().split("\\++");
				userEmpresaEntity.setIdUserEmpresa(valoresJsonVO.getAction()+valoresRegistro[4]);
				userEmpresaEntity.setActionRegistro(valoresJsonVO.getAction());
				userEmpresaEntity.setNombreRegistro(valoresRegistro[0]);
				userEmpresaEntity.setApellidoRegistro(valoresRegistro[1]);
				userEmpresaEntity.setEmailRegistro(valoresRegistro[2]);
				userEmpresaEntity.setTelefonoRegistro(valoresRegistro[3]);
				userEmpresaEntity.setUsuarioRegistro(valoresRegistro[4]);
				userEmpresaEntity.setPassRegistro(valoresRegistro[5]);
				userEmpresaEntity.setStatusRegistro("inicio");
				
				userEmpresaDAO.save(userEmpresaEntity);
				
				resultVO.setCodigo(0);
				resultVO.setMensaje("Create UserEmpresa Exito");
			}
		}catch(Exception e) {
			resultVO.setCodigo(99);
			resultVO.setMensaje("Error Create UserEmpresa");
		}
		if(resultVO.getCodigo() == 0) {
			try {
				resultVO = (ResultVO)clienteRestImpl.notificarKUENuevo(userEmpresaEntity);
				resultVO.setMensaje("Create UserEmpresa " +resultVO.getMensaje()+"\n Favor verificar su correo para validar acceso");
			}catch(Exception e) {
				resultVO.setCodigo(99);
				resultVO.setMensaje("Error Create UserEmpresa Correo");
				e.printStackTrace();
			}
				
		}

		return resultVO;//.empresaCreateDAO(empresaEntity);
	}
	
	@Override
	public ResultVO userEmpresaCreate(String idUserEmpresa) {
		
		try {
			UserEmpresaEntity userEmpresaEntity = userEmpresaDAO.findOne(idUserEmpresa);
			if(userEmpresaEntity.getStatusRegistro().equals("inicio")) {
				userEmpresaEntity.setStatusRegistro("activo");
				userEmpresaDAO.save(userEmpresaEntity);
				resultVO.setCodigo(0);
				resultVO.setMensaje("Usuario Activo");
			}else {
				resultVO.setCodigo(99);
				resultVO.setMensaje("Verificar Status, Usuario No Activo");
			}
		}catch(Exception e) {
			resultVO.setCodigo(99);
			resultVO.setMensaje("Verificar Usuario, Usuario no Existente");
			e.printStackTrace();
		}
		
		return resultVO;
	}

	@Override
	public ResultArrayVO userEmpresaRead(ValoresJsonVO valoresJsonVO) {
		String[] valoresRegistro = valoresJsonVO.getValoresFinales().split("\\++");
		logger.info(valoresJsonVO.getValoresFinales());
		UserEmpresaEntity userEmpresaEntity = new UserEmpresaEntity();
		ArrayList<String> resultArray = new ArrayList<String>();
		
		try {
			userEmpresaEntity = userEmpresaDAO.findOne(valoresJsonVO.getAction()+valoresRegistro[0]);
			if(userEmpresaEntity.getStatusRegistro().equals("activo")) {
				if(userEmpresaEntity.getPassRegistro().equals(valoresRegistro[1])) {
					userEmpresaEntity.setMonitorRegistro(valoresRegistro[2]);
					userEmpresaDAO.save(userEmpresaEntity);
					resultArray.add(userEmpresaEntity.getIdUserEmpresa()+"++"+userEmpresaEntity.getNombreRegistro());
			
					resultArrayVO = citaServiceImpl.citaServiceRead(valoresJsonVO.getAction().toString());
					if(resultArrayVO.getCodigo()==0) {
						resultArray.addAll(resultArrayVO.getMensaje());
					}else {
						resultArray.add("Error de Fecha Calendario");
					}
					resultArrayVO.setMensaje(resultArray);
				}else {
					resultArrayVO.setCodigo(98);
					resultArray.add("Usuario > Password inválidos");
					resultArrayVO.setMensaje(resultArray);
				}
			}else {
				resultArrayVO.setCodigo(98);
				resultArray.add("Usuario > No Activo");
				resultArrayVO.setMensaje(resultArray);
			}
		
		}catch(Exception e) {
			resultArrayVO.setCodigo(99);
			resultArray.add("Usuario > Password inválidos");
			resultArrayVO.setMensaje(resultArray);
		}				
		
		
		for(String campo : resultArrayVO.getMensaje()) {
			logger.info(campo);
		}
		
		return resultArrayVO;//.empresaCreateDAO(empresaEntity);
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

	@Override
	public UserEmpresaEntity userEmpresaRead(String idUserEmpresa) {
		
		UserEmpresaEntity userEmpresaEntity = new UserEmpresaEntity();
		try {
			userEmpresaEntity = userEmpresaDAO.findOne(idUserEmpresa);
		}catch(Exception e) {
			userEmpresaEntity.setMessageRegistro(e.toString());
		}				
		
		return userEmpresaEntity;
	}

	

}
