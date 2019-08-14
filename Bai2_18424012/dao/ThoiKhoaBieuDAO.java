package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.ThoiKhoaBieu;
public class ThoiKhoaBieuDAO {
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addThoiKhoaBieu("17HCB","T","Csdl","C32");
	    showAllThoiKhoaBieu();
	}
	public static void showAllThoiKhoaBieu() {
		Session session= factory.openSession();
		try{
			session.beginTransaction();

			List<ThoiKhoaBieu> list = session.createQuery("from ThoiKhoaBieu").list();
			for (ThoiKhoaBieu item : list) {
				System.out.println(item.getMalop() + "\t" + item.getMamon()
				+ "\t" + item.getTenmon() + "," + item.getPhonghoc());
			}
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}
	public static void addThoiKhoaBieu(String malop, String mamon, String tenmon, String phonghoc) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			System.out.println("Begin:");
			ThoiKhoaBieu new_item = new ThoiKhoaBieu(malop, mamon, tenmon, phonghoc);
			session.save(new_item);
		
			session.getTransaction().commit();
			System.out.println("Commit");
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
