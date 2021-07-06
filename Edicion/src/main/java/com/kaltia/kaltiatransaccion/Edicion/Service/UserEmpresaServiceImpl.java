package com.kaltia.kaltiatransaccion.Edicion.Service;

import java.util.ArrayList;
import java.util.List;

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
private CitaEmpresaService citaEmpresaService;
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
				userEmpresaEntity.setIdUserEmpresa(valoresJsonVO.getAction()+"--"+valoresRegistro[4]);
				userEmpresaEntity.setIdEmpresa(valoresJsonVO.getIdEmpresa());
				userEmpresaEntity.setActionRegistro(valoresJsonVO.getAction());
				userEmpresaEntity.setNombreRegistro(valoresRegistro[0]);
				userEmpresaEntity.setApellidoRegistro(valoresRegistro[1]);
				userEmpresaEntity.setEmailRegistro(valoresRegistro[2]);
				userEmpresaEntity.setTelefonoRegistro(valoresRegistro[3]);
				userEmpresaEntity.setUsuarioRegistro(valoresRegistro[4]);
				userEmpresaEntity.setPassRegistro(valoresRegistro[5]);
				userEmpresaEntity.setMessageRegistro(valoresRegistro[6]);
				userEmpresaEntity.setStatusRegistro("Usuario nuevo registro");
				
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
				/*
				 * Envia correo de validacion UserEmpresaCreate
				 */
				resultVO = (ResultVO)clienteRestImpl.notificarKUENuevo(userEmpresaEntity, valoresJsonVO.getNombreCorto());
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
	public List<UserEmpresaEntity> userEmpresaReadList(String idAction, String idUserEmpresa) {
		List<UserEmpresaEntity> userEmpresaEntity =new ArrayList<UserEmpresaEntity>();
		if(idUserEmpresa.equals("0")) {
			userEmpresaEntity = userEmpresaDAO.findByActionRegistro(idAction);
		}else {
			userEmpresaEntity = userEmpresaDAO.findByIdUserEmpresa(idUserEmpresa);
		}
		
		return userEmpresaEntity;
	}

	@Override
	public ResultVO userEmpresaRead(ValoresJsonVO valoresJsonVO) {
		String[] valoresRegistro = valoresJsonVO.getValoresFinales().split("\\++");
		logger.info(valoresJsonVO.getValoresFinales());
		UserEmpresaEntity userEmpresaEntity = new UserEmpresaEntity();
		ArrayList<String> resultArray = new ArrayList<String>();
		
		try {  //identidad userEmpresa
			userEmpresaEntity = userEmpresaDAO.findOne(valoresJsonVO.getAction()+valoresRegistro[0]);
			if(userEmpresaEntity.getStatusRegistro().equals("activo")) {
				if(userEmpresaEntity.getPassRegistro().equals(valoresRegistro[1])) {
					userEmpresaEntity.setMonitorRegistro(valoresRegistro[2]);
					userEmpresaDAO.save(userEmpresaEntity);
					try { // Datos de los recursos de Empresa Valores de Horarios
						resultVO = (citaEmpresaService.citaEmpresaServiceRead(valoresJsonVO.getAction().toString()));
						resultVO.setMensaje("Bienvenido "+userEmpresaEntity.getNombreRegistro()+" "+userEmpresaEntity.getApellidoRegistro());
						
						if(resultVO.getCodigo()==0) {
							resultArray.add(userEmpresaEntity.getIdUserEmpresa());
							resultArray.add(userEmpresaEntity.getNombreRegistro());
							resultArray.addAll(resultVO.getMensajeArray());
							
						}else {
							resultArray.add("Error de Fecha Calendario");
						}
						resultVO.setMensajeArray(resultArray);	
					}catch(Exception e) {
						resultVO.setCodigo(98);
						//resultArray.add("Usuario > Password inválidos");
						resultVO.setMensaje("Error en Obtener Datos Empresa");
					}
				}else {
					resultVO.setCodigo(98);
					//resultArray.add("Usuario > Password inválidos");
					resultVO.setMensaje("Usuario > Password inválidos");
				}
			}else {
				resultVO.setCodigo(98);
				//resultArray.add();
				resultVO.setMensaje("Usuario > No Activo");
			}
		}catch(Exception e) {
			resultVO.setCodigo(99);
			//resultArray.add();
			resultVO.setMensaje("Usuario > Password inválidos");
		}				
		
		return resultVO;
	}
	
	@Override
	public ResultVO userEmpresaUpdate(ValoresJsonVO valoresJsonVO) {
		try {
			String[] valoresRegistro = valoresJsonVO.getValoresFinales().split("\\++");
			logger.info(valoresJsonVO.getValoresFinales());
			UserEmpresaEntity userEmpresaEntity = userEmpresaDAO.findOne(valoresRegistro[0]);
			if(userEmpresaEntity.getIdUserEmpresa()!=null) {	
				userEmpresaEntity.setNombreRegistro(valoresRegistro[1]);
				userEmpresaEntity.setApellidoRegistro(valoresRegistro[2]);
				userEmpresaEntity.setEmailRegistro(valoresRegistro[3]);
				userEmpresaEntity.setTelefonoRegistro(valoresRegistro[4]);
				userEmpresaEntity.setUsuarioRegistro(valoresRegistro[5]);
				userEmpresaEntity.setPassRegistro(valoresRegistro[6]);
				userEmpresaEntity.setMessageRegistro(valoresRegistro[7]);
				
				userEmpresaDAO.save(userEmpresaEntity);
				resultVO.setCodigo(0);
				resultVO.setMensaje("Usuario Edicion");
			}
			else {
				resultVO.setCodigo(99);
				resultVO.setMensaje("Usuario NO Edicion - no concuerda Identidad de Usuario");
			}
				
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		
		return resultVO;
	}

	@Override
	public ResultVO userEmpresaUpdate(String idUserEmpresa) {
		try {
			UserEmpresaEntity userEmpresaEntity = userEmpresaDAO.findOne(idUserEmpresa);
			if(userEmpresaEntity.getStatusRegistro().equals("Usuario nuevo registro")) {
				userEmpresaEntity.setStatusRegistro("Usuario mail confirmado");
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
		
		return resultVO;	}

	@Override
	public ResultVO userEmpresaDelete(String idUserEmpresa) {
		
		try {
			userEmpresaDAO.delete(idUserEmpresa);
			resultVO.setCodigo(0);
			resultVO.setMensaje("Usuario "+idUserEmpresa+" ha sido eliminado");
			logger.info(resultVO.getMensaje());
		}catch(Exception e) {
			resultVO.setCodigo(99);
			resultVO.setMensaje("Error al eliminar:"+idUserEmpresa);
			logger.info(resultVO.getMensaje());
		}
		
		
		return resultVO;
	}

	public ResultArrayVO getResultArrayVO() {
		return resultArrayVO;
	}

	public void setResultArrayVO(ResultArrayVO resultArrayVO) {
		this.resultArrayVO = resultArrayVO;
	}

	


	

}
