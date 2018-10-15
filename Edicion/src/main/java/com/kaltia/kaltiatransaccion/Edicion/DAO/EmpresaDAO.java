package com.kaltia.kaltiatransaccion.Edicion.DAO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaltia.kaltiatransaccion.Edicion.VO.EmpresaEntity;

@Repository("empresaDAO")
public interface EmpresaDAO extends JpaRepository<EmpresaEntity, Serializable>{
	
//	public  ResultVO empresaCreateDAO(EmpresaEntity empresaEntity);
//	public abstract ResultVO empresaReadDAO();
//	public abstract ResultVO empresaUpdateDAO();
//	public abstract ResultVO empresaDeleteDAO();

}
