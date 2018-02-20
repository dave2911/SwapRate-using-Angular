package com.sim.utility;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@SuppressWarnings("deprecation")
public class HibernateUtility {
	
/*	private static final SessionFactory sessionFactory;
	static {
		try{
			sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		}
		catch(Throwable throwable){
			System.out.println("error");
			throw new ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}*/
	private static Configuration configuration;
	 private static SessionFactory sessionFactory;

	 static {
	  configuration = new Configuration().configure("hibernate.cfg.xml");
	  sessionFactory = configuration.buildSessionFactory();
	 }

	 public static Session getSession() {
	  Session session = null;
	  if (sessionFactory != null) {
	   session = sessionFactory.openSession();
	  }
	  return session;
	 }


}
