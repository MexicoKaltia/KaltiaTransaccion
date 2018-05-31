package com.kaltia.kaltiaTransaccion.ws;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kaltia.kaltiaTransaccion.VO.VOMail;
import com.kaltia.kaltiaTransaccion.service.Mail;

@Path("/transaccionMail")
public class TransaccionMail {
	
	@POST
	@Path("/envioMail")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOMail envioMail(VOMail voMail) {
		java.util.Date date = new java.util.Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
											//      dd/MM/yyyy
											//		HH:mm:ss dd/MM/yyyy
		String inicio = hourFormat.format(date);
		
		Mail mail = new Mail();
		//mail.mandarCorreo();
		
		voMail.setMensaje("inicio:"+inicio+"\t final:"+hourFormat.format(date));
		
		return voMail;
	}

}
