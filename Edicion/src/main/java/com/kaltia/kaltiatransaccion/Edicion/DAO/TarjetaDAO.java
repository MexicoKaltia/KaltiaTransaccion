package com.kaltia.kaltiatransaccion.Edicion.DAO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaltia.kaltiatransaccion.Edicion.VO.FooterEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.TarjetaEntity;

@Repository("tarjetaDAO")
public interface TarjetaDAO extends JpaRepository<TarjetaEntity, Serializable>{


}
