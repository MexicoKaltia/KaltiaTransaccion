package com.kaltia.kaltiatransaccion.Edicion.DAO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaltia.kaltiatransaccion.Edicion.VO.BodyEntity;

@Repository("bodyDAO")
public interface BodyDAO extends JpaRepository<BodyEntity, Serializable>{





}
