package com.kaltia.kaltiatransaccion.Edicion.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiatransaccion.Edicion.DAO.EmpresaDAO;
import com.kaltia.kaltiatransaccion.Edicion.VO.EmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

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
	@Autowired
	private ResultVO resultVO;
	@Autowired
	private CitaEmpresaService citaEmpresaService;

	@Override
	public ResultVO empresaServiceCreate(ValoresJsonVO valoresJsonVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultVO empresaServiceCreateModulos(ValoresJsonVO valoresJsonVO) {
		String idAction = valoresJsonVO.getAction();
//		logger.info("valoresJsonVO:"+valoresJsonVO.getValoresFinales());
//		String []valoresFinales = valoresJsonVO.getValoresFinales().split("\\++");
//		
//		if(!valoresFinales[0].equals("No Activo")) {
//			try {
//				citaEmpresaService.citaEmpresaServiceCreate(idAction, valoresFinales[0]);
//			} catch (Exception e) {
//				e.printStackTrace();
//				//logica por hay error en guardar los horarios
//			}
//			/*
//			 * Aqui puedo hacer algo mas con los modulos
//			 */
//		}
		
		
		try {
				Runtime rt = Runtime.getRuntime();
			    String commands = ("/kaltia/shell/EmpresaNueva.sh "+idAction);
			    Process proc = rt.exec(commands);
			    BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			    BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			    logger.info("Salida EmpresaNueva:\n");
			    String s = null;
			    while ((s = stdInput.readLine()) != null) {
			    	logger.info(s);
			    }

			    while ((s = stdError.readLine()) != null) {
			    	logger.info(s);
			      }
						resultVO.setCodigo(0);
						resultVO.setMensaje("Alta Exitosa Carpeta");

			    } catch (IOException ioe) {
			    	logger.info("ERROR Ejecutando script EmpresaNueva.sh");
						resultVO.setCodigo(99);
						resultVO.setMensaje("Falla crear Carpeta");

			    }
		return resultVO;
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
