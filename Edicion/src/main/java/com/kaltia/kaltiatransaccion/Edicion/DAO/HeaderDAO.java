package com.kaltia.kaltiatransaccion.Edicion.DAO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaltia.kaltiatransaccion.Edicion.VO.HeaderEntity;



@Repository("headerDAO")
public interface HeaderDAO extends JpaRepository<HeaderEntity, Serializable>{


}
