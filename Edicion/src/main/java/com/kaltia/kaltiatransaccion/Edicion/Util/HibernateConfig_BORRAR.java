package com.kaltia.kaltiatransaccion.Edicion.Util;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;

//@Configuration
public class HibernateConfig_BORRAR {
	
//	@Autowired
	private  EntityManagerFactory entityManagerFactory;
	
//	@Bean
	public SessionFactory getSessionFactory() {
		if(entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("Factory is not hibernate");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}

}
