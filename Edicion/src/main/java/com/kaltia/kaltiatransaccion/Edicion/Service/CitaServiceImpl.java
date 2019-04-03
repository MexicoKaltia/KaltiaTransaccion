package com.kaltia.kaltiatransaccion.Edicion.Service;

import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiatransaccion.Edicion.DAO.CitaDAO;
import com.kaltia.kaltiatransaccion.Edicion.VO.CitaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

@Service("citaServiceImpl")
public class CitaServiceImpl implements CitaService {
	
	private static final long serialVersionUID = -2559787777079230762L;

		protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ResultVO resultVO;
	
	@Autowired
	@Qualifier("citaDAO")
	private CitaDAO citaDAO;
	
	private static Calendar fecha = Calendar.getInstance();
	
	@Override
	public ResultVO citaServiceCreate(ValoresJsonVO valoresJsonVO) throws Exception {
		/*
		 * action: "bronea", idEmpresa: "broneauser", valoresFinales: "18/04/2019|1230"
		 */
		try {
			CitaEntity citaEntity = citaEntityRead(valoresJsonVO.getAction());
			String[] fecha = valoresJsonVO.getValoresFinales().split("\\/");
			String horaCita = fecha[2].substring(fecha[2].indexOf('|')+1, fecha[2].length());
//			logger.info("fecha"+fecha[0]+"-"+fecha[1]+"-"+fecha[2].substring(0, fecha[2].indexOf('|')));
//			logger.info("hora"+horaCita);
			String mesCita = numMes(Integer.valueOf(fecha[1])-1, citaEntity);
//			logger.info("mesCita"+mesCita);
			JSONParser parser = new JSONParser();
			JSONObject jsonMesCita = (JSONObject) parser.parse(mesCita);
//			logger.info("jsonMesCita"+jsonMesCita);						
			ArrayList<Integer> horarioCitaA = new ArrayList<Integer>();
			
			if(jsonMesCita.containsKey(fecha[0])){
				logger.info(jsonMesCita.get(fecha[0]));
				String[] horarioCita = jsonMesCita.get(fecha[0]).toString().split(",");
				for(String in : horarioCita){
					in = in.replace("[", "");
					in = in.replace("]", "");
					horarioCitaA.add(Integer.parseInt(in));
				}				
			}
			horarioCitaA.add(Integer.parseInt(horaCita));
			horarioCitaA.sort(null);
			jsonMesCita.put(fecha[0], horarioCitaA);
//			logger.info(jsonMesCita.get(fecha[0]));
			String valorCitaFinal = jsonMesCita.toJSONString();
//			logger.info(valorCitaFinal);
			citaEntity  = numMesSet(Integer.valueOf(fecha[1])-1, citaEntity ,valorCitaFinal);
			cityEntityUpdate(citaEntity);
			
			try {
				
			}catch(Exception e){
				
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return resultVO;
	}

	@Override
	public ResultVO citaServiceRead(String action) {
		
		//CitaEntity citaEntity = new CitaEntity();
		String mesActual;
		String mesMas;
		ArrayList<String> meses = new ArrayList<String>();
		
		try {
			CitaEntity citaEntity = citaEntityRead(action); 
			mesActual= numMes(fecha.get(Calendar.MONTH), citaEntity);
			
			if(fecha.get(Calendar.MONTH)+1 == 12) {
				mesMas = numMes(0, citaEntity);
			}else {
				mesMas = numMes(fecha.get(Calendar.MONTH)+1, citaEntity);
			}
			meses.add(citaEntity.getCondicionesCita());
			meses.add(mesActual);
			meses.add(mesMas);
			resultVO.setCodigo(0);
			resultVO.setMensajeArray(meses);
			
		}catch(Exception e){
			e.printStackTrace() ;
			resultVO.setCodigo(99);
			ArrayList<String> exceptionE= new ArrayList<String>();
			exceptionE.add(e.toString());
			resultVO.setMensaje("Error de lectura Citas idEmpresa:"+action);
		}
		
		
		return resultVO;
	}

	

	@Override
	public ResultVO citaServiceUpdate(ValoresJsonVO valoresJsonVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultVO citaServiceDelete() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private CitaEntity citaEntityRead(String action) {
		CitaEntity citaEntity = new CitaEntity();
		try {
		citaEntity = citaDAO.findOne(action);
		}catch(Exception e) {
			citaEntity.setIdAction("Verificar calendario de "+action);
		}
		return citaEntity;
	}
	
	private void cityEntityUpdate(CitaEntity citaEntity) {
		try {
			citaDAO.save(citaEntity);
			}catch(Exception e) {
				citaEntity.setIdAction("Verificar actualizacion de Citas");
			}
	}
	
	private String numMes(Integer mes, CitaEntity citaEntity) {
		logger.info("mes:"+mes);
		String columna = "";
		
		switch (mes) {		
		case 0:
			columna =  citaEntity.getEneroCita();
			break;
		case 1:
			columna =  citaEntity.getFebreroCita();
			break;
		case 2:
			columna =  citaEntity.getMarzoCita();
			break;
		case 3:
			columna =  citaEntity.getAbrilCita();
			break;
		case 4:
			columna =  citaEntity.getMayoCita();
			break;
		case 5:
			columna =  citaEntity.getJunioCita();
			break;
		case 6:
			columna =  citaEntity.getJulioCita();
			break;
		case 7:
			columna =  citaEntity.getAgostoCita();
			break;
		case 8:
			columna =  citaEntity.getSeptiembreCita();
			break;
		case 9:
			columna =  citaEntity.getOctubreCita();
			break;
		case 10:
			columna =  citaEntity.getNoviembreCita();
			break;
		case 11:
			columna =  citaEntity.getDiciembreCita();
			break;
		}
		return columna;
	}
	
	private CitaEntity numMesSet(Integer mes, CitaEntity  citaEntity ,  String valorCitaFinal) {
		
		logger.info("mes:"+mes);
		String columna = "";
		
		switch (mes) {		
		case 0:
			citaEntity.setEneroCita(valorCitaFinal);
			break;
		case 1:
			citaEntity.setFebreroCita(valorCitaFinal);
			break;
		case 2:
			citaEntity.setMarzoCita(valorCitaFinal);
			break;
		case 3:
			citaEntity.setAbrilCita(valorCitaFinal);
			break;
		case 4:
			citaEntity.setMayoCita(valorCitaFinal);
			break;
		case 5:
			citaEntity.setJunioCita(valorCitaFinal);
			break;
		case 6:
			citaEntity.setJulioCita(valorCitaFinal);
			break;
		case 7:
			citaEntity.setAgostoCita(valorCitaFinal);
			break;
		case 8:
			citaEntity.setSeptiembreCita(valorCitaFinal);
			break;
		case 9:
			citaEntity.setOctubreCita(valorCitaFinal);
			break;
		case 10:
			citaEntity.setNoviembreCita(valorCitaFinal);
			break;
		case 11:
			citaEntity.setDiciembreCita(valorCitaFinal);
			break;
		}
		
		return citaEntity;
	}

}
