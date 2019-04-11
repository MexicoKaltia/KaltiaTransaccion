package com.kaltia.kaltiatransaccion.Edicion.Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiatransaccion.Edicion.DAO.BodyDAO;
import com.kaltia.kaltiatransaccion.Edicion.DAO.EmpresaDAO;
import com.kaltia.kaltiatransaccion.Edicion.DAO.FooterDAO;
import com.kaltia.kaltiatransaccion.Edicion.DAO.HeaderDAO;
import com.kaltia.kaltiatransaccion.Edicion.VO.BodyEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.EmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.FooterEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.HeaderEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

@Service("edicionServiceImpl")
public class EdicionServiceImpl implements EdicionService{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
@Autowired
private ResultVO resultVO;

@Autowired
@Qualifier("empresaDAO")
private EmpresaDAO empresaDAO;

@Autowired
@Qualifier("headerDAO")
private HeaderDAO headerDAO;
@Autowired
@Qualifier("bodyDAO")
private BodyDAO bodyDAO;
@Autowired
@Qualifier("footerDAO")
private FooterDAO footerDAO;

	@Override
	public ResultVO edicionServiceCreate() {
		
		EmpresaEntity empresaEntity= new EmpresaEntity();
//		empresaEntity.setIdEmpresa("idEmpresa21");
//		empresaEntity.setIdAction("idAction");
//		empresaEntity.setEmpresaNombreCompleto("empresaNombreCompleto");
//		empresaEntity.setEmpresaRFC("empresaRFC");
//		empresaEntity.setEmpresaDireccion("empresaDireccion");
//		empresaEntity.setEmpresaEmail("empresaEmail");
//		empresaEntity.setEmpresaContacto("empresaContacto");
//		empresaEntity.setEmpresaIdPerfilE("empresaIdPerfilE");
//		empresaEntity.setEmpresaVarios("empresaVarios");
//		empresaEntity.setEmpresaIdPerfilI("empresaIdPerfilI");
//		empresaEntity.setEmpresaModelo("empresaModelo");
//		empresaEntity.setEmpresaStatus("empresaStatus");
//		empresaEntity.setEmpresaFechaCorte("empresaFechaCorte");
//		empresaEntity.setEmpresaModoPago("empresaModoPago");
//		empresaEntity.setEmpresaFactura("empresaFactura");
		
		empresaDAO.save(empresaEntity);
		
		resultVO.setCodigo(0);
		resultVO.setMensaje("Llegando al DAO con injeccion de dependencias");
		
		return resultVO;//.empresaCreateDAO(empresaEntity);
//		return null;
	}

	@Override
	public ResultVO edicionServiceRead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultVO edicionServiceUpdate(ValoresJsonVO valoresJsonVO) {
		
		String modulo = valoresJsonVO.getSeccion().substring(0, valoresJsonVO.getSeccion().indexOf("Seccion"));
		logger.info("\nIdEmpresa:" + valoresJsonVO.getIdEmpresa() + "\nModulo:" + modulo +  "\nValoresFinales:" + valoresJsonVO.getValoresFinales());
		
		switch (modulo) {
		case "header":
			HeaderEntity headerEntity = new HeaderEntity();
			headerEntity = headerDAO.findOne(valoresJsonVO.getIdEmpresa()+"-"+modulo);
			switch (valoresJsonVO.getSeccion().toString()) {
			case "headerSeccion1":
				headerEntity.setHeaderSeccion1(valoresJsonVO.getValoresFinales());
				break;
			case "headerSeccion2":
				headerEntity.setHeaderSeccion2(valoresJsonVO.getValoresFinales());
				break;
			case "headerSeccion3":
				headerEntity.setHeaderSeccion3(valoresJsonVO.getValoresFinales());
				break;
			case "headerSeccion4":
				headerEntity.setHeaderSeccion4(valoresJsonVO.getValoresFinales());
				break;
			case "headerSeccion5":
				headerEntity.setHeaderSeccion5(valoresJsonVO.getValoresFinales());
				break;
			case "headerSeccionArray1":
				headerEntity.setHeaderSeccionArray1(valoresJsonVO.getValoresFinales());
				break;
			case "headerSeccionArray2":
				headerEntity.setHeaderSeccionArray2(valoresJsonVO.getValoresFinales());
				break;
			case "headerSeccionArray3":
				headerEntity.setHeaderSeccionArray3(valoresJsonVO.getValoresFinales());
				break;
			case "headerSeccionArray4":
				headerEntity.setHeaderSeccionArray4(valoresJsonVO.getValoresFinales());
				break;
			case "headerSeccionArray5":
				headerEntity.setHeaderSeccionArray5(valoresJsonVO.getValoresFinales());
				break;
			}
			try {
			headerDAO.save(headerEntity);
			resultVO.setCodigo(0);
			resultVO.setMensaje("Actualizacion Empresa:"+ valoresJsonVO.getIdEmpresa()+ ", en la seccion:"+ valoresJsonVO.getSeccion().toString() + ",  EXITOSA");
		}catch(Exception e) {
			resultVO.setCodigo(99);
			resultVO.setMensaje("Falla Empresa:"+ valoresJsonVO.getIdEmpresa()+ ", en la seccion:"+ valoresJsonVO.getSeccion().toString() );
		}
			break;
			
		case "body":
			BodyEntity bodyEntity = new BodyEntity();
			bodyEntity = bodyDAO.findOne(valoresJsonVO.getIdEmpresa()+"-"+modulo);
			switch (valoresJsonVO.getSeccion().toString()) {
			case "bodySeccionArray1":
				bodyEntity.setBodySeccionArray1(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccionArray2":
				bodyEntity.setBodySeccionArray2(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccionArray3":
				bodyEntity.setBodySeccionArray3(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccionArray4":
				bodyEntity.setBodySeccionArray4(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccionArray5":
				bodyEntity.setBodySeccionArray5(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccionArray6":
				bodyEntity.setBodySeccionArray6(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccionArray7":
				bodyEntity.setBodySeccionArray7(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccion1":
				bodyEntity.setBodySeccion1(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccion2":
				bodyEntity.setBodySeccion2(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccion3":
				bodyEntity.setBodySeccion3(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccion4":
				bodyEntity.setBodySeccion4(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccion5":
				bodyEntity.setBodySeccion5(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccion6":
				bodyEntity.setBodySeccion6(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccion7":
				bodyEntity.setBodySeccion7(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccion8":
				bodyEntity.setBodySeccion8(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccion9":
				bodyEntity.setBodySeccion9(valoresJsonVO.getValoresFinales());
				break;
			case "bodySeccion10":
				bodyEntity.setBodySeccion10(valoresJsonVO.getValoresFinales());
				break;
			}
			try {
				bodyDAO.save(bodyEntity);
				resultVO.setCodigo(0);
				resultVO.setMensaje("Actualizacion Empresa:"+ valoresJsonVO.getIdEmpresa()+ ", en la seccion:"+ valoresJsonVO.getSeccion().toString() + ",  EXITOSA");
			}catch(Exception e) {
				resultVO.setCodigo(99);
				resultVO.setMensaje("Falla Empresa:"+ valoresJsonVO.getIdEmpresa()+ ", en la seccion:"+ valoresJsonVO.getSeccion().toString() );
			}
			break;
			
		case "footer":
			FooterEntity footerEntity = new FooterEntity();
			footerEntity = footerDAO.findOne(valoresJsonVO.getIdEmpresa()+"-"+modulo);
			switch (valoresJsonVO.getSeccion().toString()) {
			case "footerSeccion1":
				footerEntity.setFooterSeccion1(valoresJsonVO.getValoresFinales());
				break;
			case "footerSeccion2":
				footerEntity.setFooterSeccion2(valoresJsonVO.getValoresFinales());
				break;
			case "footerSeccion3":
				footerEntity.setFooterSeccion3(valoresJsonVO.getValoresFinales());
				break;
			case "footerSeccion4":
				footerEntity.setFooterSeccion4(valoresJsonVO.getValoresFinales());
				break;
			case "footerSeccion5":
				footerEntity.setFooterSeccion5(valoresJsonVO.getValoresFinales());
				break;
			case "footerSeccionArray1":
				footerEntity.setFooterSeccionArray1(valoresJsonVO.getValoresFinales());
				break;
			case "footerSeccionArray2":
				footerEntity.setFooterSeccionArray2(valoresJsonVO.getValoresFinales());
				break;
			}
			try {
				footerDAO.save(footerEntity);
				resultVO.setCodigo(0);
				resultVO.setMensaje("Actualizacion Empresa:"+ valoresJsonVO.getIdEmpresa()+ ", en la seccion:"+ valoresJsonVO.getSeccion().toString() + ",  EXITOSA");
			}catch(Exception e) {
				resultVO.setCodigo(99);
				resultVO.setMensaje("Falla Empresa:"+ valoresJsonVO.getIdEmpresa()+ ", en la seccion:"+ valoresJsonVO.getSeccion().toString() );
			}
			break;
		}
		logger.info(resultVO.getCodigo());
		logger.info(resultVO.getJsonResponse());
		logger.info(resultVO.getMensaje());
		logger.info(resultVO.getMensajeArray());
		logger.info(resultVO.getResponse());
		return resultVO;
	}

	@Override
	public ResultVO edicionServiceDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
