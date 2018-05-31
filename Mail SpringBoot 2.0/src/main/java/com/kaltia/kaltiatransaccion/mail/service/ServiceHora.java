package com.kaltia.kaltiatransaccion.mail.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

@Service
public class ServiceHora {

	public String hora() {
		
		java.util.Date date = new java.util.Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
											//      dd/MM/yyyy
											//		HH:mm:ss dd/MM/yyyy
		
		return hourFormat.format(date);
	}
	
}
