package com.kaltia.kaltiatransaccion.Edicion.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiatransaccion.Edicion.DAO.EmpresaDAO;
import com.kaltia.kaltiatransaccion.Edicion.VO.EmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;

@Service("edicionServiceImpl")
public class EdicionServiceImpl implements EdicionService{
	
//@Autowired
//private EmpresaEntity empresaEntity;
@Autowired
private ResultVO resultVO;

@Autowired
@Qualifier("empresaDAO")
private EmpresaDAO empresaDAO;

	@Override
	public ResultVO edicionServiceCreate() {
		
		EmpresaEntity empresaEntity= new EmpresaEntity();
		empresaEntity.setIdEmpresa("idEmpresa21");
		empresaEntity.setIdAction("idAction");
		empresaEntity.setEmpresaNombreCompleto("empresaNombreCompleto");
		empresaEntity.setEmpresaRFC("empresaRFC");
		empresaEntity.setEmpresaDireccion("empresaDireccion");
		empresaEntity.setEmpresaEmail("empresaEmail");
		empresaEntity.setEmpresaContacto("empresaContacto");
		empresaEntity.setEmpresaIdPerfilE("empresaIdPerfilE");
		empresaEntity.setEmpresaVarios("empresaVarios");
		empresaEntity.setEmpresaIdPerfilI("empresaIdPerfilI");
		empresaEntity.setEmpresaModelo("empresaModelo");
		empresaEntity.setEmpresaStatus("empresaStatus");
		empresaEntity.setEmpresaFechaCorte("empresaFechaCorte");
		empresaEntity.setEmpresaModoPago("empresaModoPago");
		empresaEntity.setEmpresaFactura("empresaFactura");
		
		empresaDAO.save(empresaEntity);
		
		resultVO.setCodigo(99);
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
	public ResultVO edicionServiceUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultVO edicionServiceDelete() {
		// TODO Auto-generated method stub
		return null;
	}

}
