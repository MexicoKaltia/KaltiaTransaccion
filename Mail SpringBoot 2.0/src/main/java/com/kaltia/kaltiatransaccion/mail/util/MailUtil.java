package com.kaltia.kaltiatransaccion.mail.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kaltia.kaltiatransaccion.mail.vo.ValoresJSONVO;

public class MailUtil {

	protected final static Log logger = LogFactory.getLog(MailUtil.class);
	
	public MailUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static void printWSEdicion(ValoresJSONVO valoresJsonVO, String string) {
		logger.info("_________________________________________");
		logger.info(string);
		logger.info(":"+valoresJsonVO.toString());  //OK
	}

}
