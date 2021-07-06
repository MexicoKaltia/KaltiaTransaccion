package com.kaltia.kaltiatransaccion.mail.ws;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaltia.kaltiatransaccion.mail.service.ServiceHora;
import com.kaltia.kaltiatransaccion.mail.util.MailUtil;
import com.kaltia.kaltiatransaccion.mail.service.MailService;
import com.kaltia.kaltiatransaccion.mail.service.MailServiceImpl;
import com.kaltia.kaltiatransaccion.mail.vo.MailVO;
import com.kaltia.kaltiatransaccion.mail.vo.ResultVO;
import com.kaltia.kaltiatransaccion.mail.vo.VOHora;
import com.kaltia.kaltiatransaccion.mail.vo.ValoresJSONVO;

@RestController
@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz",  "*"})
@RequestMapping("mail")
public class WSMail {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private final MailService mailService;
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
	
	@GetMapping("/version")
	public  String version() {
		return  "23012020";
	}

	
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public VOHora getHora() {
		MailUtil.printWSEdicion(new ValoresJSONVO(""), "/");
		return new VOHora(serviceHora.hora());
		//return "hora:"+serviceHora.hora(); 
	}
	
//	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080","https://kaltia.xyz", "https://www.kaltia.xyz", "https://kaltiacontrol.xyz", "https://www.kaltiacontrol.xyz"})
	@RequestMapping(method = RequestMethod.POST,path = "{envioMail}",consumes  = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultVO envioMail(@RequestBody ValoresJSONVO valoresJSONVO) {
		String inicio = serviceHora.hora();
		MailUtil.printWSEdicion(valoresJSONVO, "/{envioMail}");
		resultVO = mailService.mailServiceCreate(valoresJSONVO);
		
		mailVO.setMensaje("inicio:"+inicio+"\t final:"+serviceHora.hora());
		
		return resultVO;
	}
	
//	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080","https://kaltia.xyz", "https://www.kaltia.xyz", "https://kaltiacontrol.xyz", "https://www.kaltiacontrol.xyz"})
	@RequestMapping(method = RequestMethod.POST,path = "/notificarKUENuevo",consumes  = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultVO notificarKUENuevo(@RequestBody ValoresJSONVO valoresJSONVO) {

		MailUtil.printWSEdicion(valoresJSONVO, "/notificarKUENuevo");
		resultVO = mailService.mailServiceNotificarKUENuevo(valoresJSONVO);
		
		return resultVO;
	}
	
//	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080","https://kaltia.xyz", "https://www.kaltia.xyz", "https://kaltiacontrol.xyz", "https://www.kaltiacontrol.xyz"})
	@RequestMapping(method = RequestMethod.POST,path = "/cita1",consumes  = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultVO cita1(@RequestBody ValoresJSONVO valoresJSONVO) {

		MailUtil.printWSEdicion(valoresJSONVO, "/notificarKUENuevo");
		resultVO = mailService.mailServiceNotificaCita1(valoresJSONVO);
		
		return resultVO;
	}


}
