package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pojo.BangDiem;
import pojo.Lop_SinhVien;
import pojo.SinhVien;

public class Lop_SinhVienDAO {
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	public Lop_SinhVienDAO() {
		// TODO Auto-generated constructor stub
		
	}
	public static void main(String []args) {
		Lop_SinhVienDAO dao = new Lop_SinhVienDAO();
//		addLop_SinhVien("18HCB", "Chau");
		dao.showAll();
		
	}
	public void addLop_SinhVien(String malop, String masv) {
		Session session = factory.openSession();
		try {
			String malop_sv = malop + "-" + masv;
			session.beginTransaction();
			System.out.println("Begin:");
			Lop_SinhVien new_item = new Lop_SinhVien(malop_sv, malop, masv);
			session.save(new_item);
		
			session.getTransaction().commit();
			System.out.println("Commit");
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void showAll() {
		List<Lop_SinhVien> list = new ArrayList<>();
		Session session = factory.openSession();
		try{
			
			session.beginTransaction();

			list = session.createQuery("from Lop_SinhVien").list();
			for (Lop_SinhVien item : list) {
				System.out.println(item.getMalop() + "\t" + item.getMasv());
			}
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}
	public void DeleteLop_Sv(String malop, String masv) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			String query = "Delete from Lop_SinhVien where malop = :malop and masv = :masv";
			session.createQuery(query).setString("malop", malop).setString("masv", masv).executeUpdate();
		
			session.getTransaction().commit();
			System.out.println("Delete finished");
		} catch (Exception e) {
			session.getTransaction().rollback();
			// TODO: handle exception
			System.out.println(e);
		}finally {
			session.close();
		}
		
	}
	public void InsertLop_Sv(String malop, String masv) {
		addLop_SinhVien(malop, masv);
	}
}
