package dao;
import org.hibernate.cfg.Configuration;

import java.time.LocalTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.UserPass;
public class UserPassDAO {
	static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	public static void main(String []args) {
//		InsertData();

		UpdatePass();
		showAll();
		sf.close();
	}
	public static void showAll() {
		Session session = sf.openSession();
		try{
			
			session.beginTransaction();

			List<UserPass> list = session.createQuery("from UserPass").list();
			for (UserPass item : list) {
				System.out.println(item.getUsername() + "\t" + item.getPassword());
			}
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public static void UpdatePass() {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			String query = "update UserPass set password = :newPass where username = :name";
			String newPass = "giaovu";
			String name = "giaovu";
			session.createQuery(query).setString("newPass", newPass).setString("name", name).executeUpdate();
		
			session.getTransaction().commit();
			System.out.println("Insert finished");
		} catch (Exception e) {
			session.getTransaction().rollback();
			// TODO: handle exception
			System.out.println(e);
		}finally {
			session.close();
		}
		
	}
	public static void InsertData() {
		try {
//			AnnotationConfiguration cfg = new AnnotationConfiguration();
//			cfg.addAnnotatedClass(UserPass.class);
//			cfg.configure("pojo/hibernate.cfg.xml");
//			new SchemaExport(cfg).create(true,true);
//			SessionFactory sf = cfg.buildSessionFactory();
//			Session s = sf.getCurrentSession();
//			s.beginTransaction();
			Session session = sf.openSession();
			session.beginTransaction();
			

			
			UserPass new_item = new UserPass();
			LocalTime now = LocalTime.now();
			new_item.setUsername(now.toString());
			new_item.setPassword("12345");
			session.save(new_item);
		
			session.getTransaction().commit();
			System.out.println("Insert finished");
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
