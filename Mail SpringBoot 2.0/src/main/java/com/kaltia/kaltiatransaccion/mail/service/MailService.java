package com.kaltia.kaltiatransaccion.mail.service;

import java.io.Serializable;

import com.kaltia.kaltiatransaccion.mail.vo.ResultVO;
import com.kaltia.kaltiatransaccion.mail.vo.ValoresJSONVO;


public interface MailService extends Serializable{
	
	public ResultVO mailServiceCreate(ValoresJSONVO valoresJSONVO);
	public ResultVO mailServiceRead(String action);
	public ResultVO mailServiceUpdate(ValoresJSONVO valoresJsonVO);
	public ResultVO mailServiceDelete();
	
	public ResultVO mailServiceNotificarKUENuevo(ValoresJSONVO valoresJSONVO);
	
	//public ResultVO mandarCorreo(ValoresJSONVO valoresJSONVO);


}
