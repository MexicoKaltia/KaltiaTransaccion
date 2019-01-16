package com.kaltia.kaltiatransaccion.mail.ws;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaltia.kaltiatransaccion.mail.service.ServiceHora;
import com.kaltia.kaltiatransaccion.mail.service.MailServiceImpl;
import com.kaltia.kaltiatransaccion.mail.vo.MailVO;
import com.kaltia.kaltiatransaccion.mail.vo.ResultVO;
import com.kaltia.kaltiatransaccion.mail.vo.VOHora;
import com.kaltia.kaltiatransaccion.mail.vo.ValoresJSONVO;

@RestController
@RequestMapping("mail")
public class WSMail {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private final MailServiceImpl mailService;
	@Autowired
	private ServiceHora serviceHora;
//	@Autowired
//	private ValoresJSONVO valoresJSONVO;
	@Autowired
	private MailVO mailVO;
	@Autowired
	private ResultVO resultVO;
	
	@Autowired
	public WSMail(MailServiceImpl mailService) {
		this.mailService = mailService;
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@ResponseBody
	public VOHora getHora() {
		return new VOHora(serviceHora.hora());
		//return "hora:"+serviceHora.hora(); 
	}
	
	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080"})
	@RequestMapping(method = RequestMethod.POST,path = "{envioMail}",consumes  = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultVO envioMail(@RequestBody ValoresJSONVO valoresJSONVO) {
		String inicio = serviceHora.hora();
//		logger.info(valoresJSONVO.getIdEmpresa());  //OK
		resultVO = mailService.mailServiceCreate(valoresJSONVO);
		
		mailVO.setMensaje("inicio:"+inicio+"\t final:"+serviceHora.hora());
		
		return resultVO;
	}

}
