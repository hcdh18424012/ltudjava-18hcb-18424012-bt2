package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pojo.SinhVien;

public class SinhVienDAO {
	private static SessionFactory factory;
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();			
			addSinhVien("Iu","tran", null, null);
			showAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub

	}
	public static void showAll() {
		Session session = factory.openSession();
		try{
			
			session.beginTransaction();

			List<SinhVien> list = session.createQuery("from SinhVien").list();
			for (SinhVien item : list) {
				System.out.println(item.getMasv() + "\t" + item.getHoten());
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
		Session session = factory.openSession();
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
	public static void addSinhVien(String masv, String hoten, String gioitinh, String cmnd) {
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			
			SinhVien new_item = new SinhVien(masv, hoten, gioitinh, cmnd);
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
