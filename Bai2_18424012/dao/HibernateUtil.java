package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import pojo.BangDiem;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

	    if(sessionFactory==null)
	    {

	        try{
	             sessionFactory = new AnnotationConfiguration()
	            		 .configure().addAnnotatedClass(BangDiem.class)
	            		 .buildSessionFactory();
	          }catch (Throwable ex) { 
	             System.err.println("Failed to create sessionFactory object." + ex);
	             throw new ExceptionInInitializerError(ex); 
	          }
	    }
	    return sessionFactory;

	}
}
