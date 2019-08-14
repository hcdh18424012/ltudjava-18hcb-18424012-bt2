package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.BangDiem;

public class BangDiemDAO {
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addBangDiem("17HCB","T",8,9,9,9);
	    showAllBangDiem();
	}
	public static void showAllBangDiem() {
		Session session= factory.openSession();
		try{
			session.beginTransaction();

			List<BangDiem> list = session.createQuery("from BangDiem").list();
			for (BangDiem item : list) {
				System.out.println(item.getMalop() + "\t" + item.getMasv()
				+ "\t" + item.getDiemgk() + "," + item.getDiemck() +","+ item.getDiemkhac() +","+ item.getDiemtong());
			}
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}
	public static void addBangDiem(String malop, String masv, float diemgk, float diemck, float diemkhac, float diemtong) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			System.out.println("Begin:");
			BangDiem new_item = new BangDiem(malop, masv, diemgk, diemck, diemkhac, diemtong);
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
