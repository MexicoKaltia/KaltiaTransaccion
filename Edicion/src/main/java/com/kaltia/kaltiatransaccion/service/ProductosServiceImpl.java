package com.kaltia.kaltiatransaccion.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiatransaccion.Edicion.DAO.IProductosDAO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultDAOVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.VideoEntity;

@Service
public class ProductosServiceImpl implements IProductosService {

	protected final Log logger = LogFactory.getLog(getClass());
	private static final long serialVersionUID = -6261847286451961617L;
	
	@Autowired
    private ResultDAOVO resultDAOVO;
	@Autowired
    private IProductosDAO productosDAO;
	@Override
	public ResultDAOVO addVideoService(VideoEntity videoEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	@Override
//	public ResultDAOVO addVideoService(VideoEntity videoEntity) {
//		
//		logger.info(videoEntity.toString());
//		String now = (new Date()).toString();
//		videoEntity.setIdVideo(BaseInfra.idLocalTime());
//		videoEntity.setTimestamp(now);
//		videoEntity.setStatus("create");
//		
//		resultDAOVO = productosDAO.addVideoDAO(videoEntity);
//		
//		return resultDAOVO;
//	}


	

}
