package com.kaltia.kaltiatransaccion.mail.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kaltia.kaltiatransaccion.mail.service.ServiceHora;
import com.kaltia.kaltiatransaccion.mail.service.ServiceMail;
import com.kaltia.kaltiatransaccion.mail.vo.VOMail;

@RestController
@RequestMapping("mail")
public class WSMail {
	
	private final ServiceMail serviceMail;
	@Autowired
	private ServiceHora serviceHora;
	
	@Autowired
	public WSMail(ServiceMail serviceMail) {
		this.serviceMail = serviceMail;
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public String getHora() {
		return "hora:"+serviceHora.hora(); 
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			path = "{envioMail}",
			consumes  = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
		)
	public VOMail envioMail(VOMail voMail) {
		String inicio = serviceHora.hora();
		
		//VOMail mail = new VOMail();
		//mail.mandarCorreo();
		
		voMail.setMensaje("inicio:"+inicio+"\t final:"+serviceHora.hora());
		
		return voMail;
	}

}
