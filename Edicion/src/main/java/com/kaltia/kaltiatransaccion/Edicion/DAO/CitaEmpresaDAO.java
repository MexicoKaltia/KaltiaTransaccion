package com.kaltia.kaltiatransaccion.Edicion.DAO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaltia.kaltiatransaccion.Edicion.VO.CitaEmpresaEntity;

@Repository("citaEmpresaDAO")
public interface CitaEmpresaDAO extends JpaRepository<CitaEmpresaEntity, Serializable>{



}




