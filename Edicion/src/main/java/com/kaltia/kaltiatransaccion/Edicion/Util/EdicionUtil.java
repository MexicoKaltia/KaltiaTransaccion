package com.kaltia.kaltiatransaccion.Edicion.Util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

public class  EdicionUtil {
	
	protected final static Log logger = LogFactory.getLog(EdicionUtil.class);

	public EdicionUtil() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void printWSEdicion(ValoresJsonVO valoresJsonVO, String string) {
		logger.info("_________________________________________");
		logger.info(string);
		logger.info(":"+valoresJsonVO.toString());  //OK
	}


	public static void printWSEdicionJson(ValoresJsonVO valoresJsonVO, String string) {
		// TODO Auto-generated method stub
		
	}

}
