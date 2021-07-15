package com.kaltia.kaltiatransaccion.service;

import java.io.Serializable;

import com.kaltia.kaltiatransaccion.Edicion.VO.ResultDAOVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.VideoEntity;


public interface IProductosService extends Serializable{

	ResultDAOVO addVideoService(VideoEntity videoEntity);
	

}
