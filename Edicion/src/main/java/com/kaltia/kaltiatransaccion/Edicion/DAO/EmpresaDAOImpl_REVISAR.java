package com.kaltia.kaltiatransaccion.Edicion.DAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kaltia.kaltiatransaccion.Edicion.VO.EmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;

//@Repository
public  class EmpresaDAOImpl_REVISAR {//implements EmpresaDAO{
//	@Autowired
	ResultVO resultVO;
//	@Autowired
	private SessionFactory sessionFactory;

	
	 
	/*Se necesita de una transaccion activa
	 * por ello la prueba unitaria utiliza @Transactional*/
//	private Session currentSession(SessionFactory sessionFactory) {
//		return sessionFactory.getCurrentSession();
//	}
	@SuppressWarnings("unchecked")
	public ResultVO empresaCreateDAO(EmpresaEntity empresaEntity) {
		
		Session session = null;
//		currentSession(sessionFactory).saveOrUpdate(empresaEntity);
		try {
			session = sessionFactory.getCurrentSession();//.openSession();
//			session.beginTransaction();
			session.save(empresaEntity);
//			session.getTransaction().commit();
			
			resultVO.setCodigo(99);
			resultVO.setMensaje("Llegando al DAO con injeccion de dependencias");	
		}catch(Exception e) {
			resultVO.setCodigo(99);
			resultVO.setMensaje("Fallo el SesssionFactory");
			e.printStackTrace();
		}
		
		
		return resultVO;
	}

	
}
