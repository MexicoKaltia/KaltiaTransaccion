package com.kaltia.kaltiatransaccion.Edicion.DAO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaltia.kaltiatransaccion.Edicion.VO.UserEmpresaEntity;

@Repository("userEmpresaDAO")
public interface UserEmpresaDAO extends JpaRepository<UserEmpresaEntity, Serializable>{
	
//	public  ResultVO empresaCreateDAO(EmpresaEntity empresaEntity);
//	public abstract ResultVO empresaReadDAO();
//	public abstract ResultVO empresaUpdateDAO();
//	public abstract ResultVO empresaDeleteDAO();

}
