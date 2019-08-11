package dao;
import org.hibernate.cfg.Configuration; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.UserPass;
public class UserPassDAO {
	public static void main(String []args) {
		InsertData();
	}
	@SuppressWarnings("deprecation")
	public static void InsertData() {
		try {
//			AnnotationConfiguration cfg = new AnnotationConfiguration();
//			cfg.addAnnotatedClass(UserPass.class);
//			cfg.configure("pojo/hibernate.cfg.xml");
//			new SchemaExport(cfg).create(true,true);
//			SessionFactory sf = cfg.buildSessionFactory();
//			Session s = sf.getCurrentSession();
//			s.beginTransaction();
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			

			
			UserPass new_item = new UserPass();
			new_item.setUsername("4h20");
			new_item.setPassword("12345");
			session.save(new_item);
		
			session.getTransaction().commit();
			System.out.println("Insert finished");
			session.close();

			sf.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
