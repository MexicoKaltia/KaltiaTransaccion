package com.kaltia.kaltiatransaccion.Edicion.DAO;

import java.io.Serializable;

import com.kaltia.kaltiatransaccion.Edicion.VO.ChatEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultDAOVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.VideoEntity;


public interface IProductosDAO extends Serializable{

	ResultDAOVO addVideoDAO(VideoEntity videoEntity);
	ResultDAOVO getVideosService(String idEmpresa);
	ResultDAOVO getChatDAO(String idEmpresa);
	ResultDAOVO addChatDAO(ChatEntity chatEntity);
	ResultDAOVO getTarjetaProductosDAO(String idEmpresa);
}
