package dao;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import gui.Services;
import pojo.BangDiem;
import pojo.SinhVien;

public class BangDiemDAO {
	public static String filename;
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BangDiemDAO dao = new BangDiemDAO();
//		dao.addBangDiem("17HCB","HDHY", "Chau",8,9,9,9);
//		dao.addBangDiem("17HCB","HDH", "Chau",8,9,9,9);
////	    showAllBangDiem();
	}
	public void ShowTable(JTable table) {
		Object columns[] = {"", "STT", "Ma SV", "Giua Ky", "Cuoi Ky", "Diem Khac", "Diem Tong", "Ma Lop"};
	    
	    DefaultTableModel model = new DefaultTableModel(columns, 0) {
	    	public Class<?> getColumnClass(int column)
	    	{
	    		switch(column)
	    		{
	    			case 0: 
	    				return Boolean.class;

	    			default: return String.class;
	    		}
	    	}
	    };

	    table.setModel(model);
	    table.setRowHeight(30);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
	    table.getColumnModel().getColumn(0).setMaxWidth(30);
	    // STT
	    table.getColumnModel().getColumn(1).setMaxWidth(50);
	    table.getColumnModel().getColumn(2).setMaxWidth(100); // MaSV
	    table.getColumnModel().getColumn(3).setMaxWidth(100); // Diem
	    table.getColumnModel().getColumn(4).setMaxWidth(100); // 
	    table.getColumnModel().getColumn(5).setMaxWidth(100); // MaLop
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//	    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Boolean.class);
//	    renderer.setHorizontalAlignment(SwingConstants.RIGHT);
//	    table.setDefaultRenderer(table.getColumnClass(0), renderer);  
	    List<BangDiem> sv = showAllBangDiem();
	    for(int i = 0; i < sv.size(); i++) {
	    	model.addRow(new Object[0]);
	    	model.setValueAt(false, i, 0); // set checkbox
	    	model.setValueAt(i + 1, i, 1); // Số thứ tự
	    	model.setValueAt(sv.get(i).getMasv(), i, 2);
	    	model.setValueAt(sv.get(i).getDiemgk(), i, 3);
	    	model.setValueAt(sv.get(i).getDiemck(), i, 4);
	    	model.setValueAt(sv.get(i).getDiemkhac(), i, 5);
	    	model.setValueAt(sv.get(i).getDiemtong(), i, 6);
	    	model.setValueAt(sv.get(i).getMalop(), i, 7);
	    }
	}
	public static List<BangDiem> showAllBangDiem() {
		List<BangDiem> list = new ArrayList<>();
		Session session= factory.openSession();
		try{
			session.beginTransaction();

			list = session.createQuery("from BangDiem").list();
//			for (BangDiem item : list) {
//				System.out.println(item.getMalop() + "\t" + item.getMasv()
//				+ "\t" + item.getDiemgk() + "," + item.getDiemck() +","+ item.getDiemkhac() +","+ item.getDiemtong());
//			}
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return list;
	}
	public void addBangDiem(String malop, String masv, String hoten, float diemgk, float diemck, float diemkhac, float diemtong) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			System.out.println("Begin:");
			BangDiem new_item = new BangDiem(malop, masv, hoten, diemgk, diemck, diemkhac, diemtong);
			session.save(new_item);
		
			session.getTransaction().commit();
			System.out.println("Commit");
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void addBangDiemfromCSV(String f) {
		HashMap<String, String> map = Services.ReadFileCSV(f.toString());
		String []path = Paths.get(f).getFileName().toString().split("\\.");
//		filename = path[0];
		String title = map.get("title");
		map.remove("title");
		String malop = path[0];
		String masv;
		String hoten;
		float diemgk;
		float diemck;
		float diemkhac;
		float diemtong;
//		Kiem tra hop le dong dau tien

		for(String key: map.keySet()) {
//			System.out.println(map.get(key));
			String arrItem[] = map.get(key).split(",");
			try {
				masv = arrItem[1].trim();
				hoten = arrItem[2].trim();
				diemgk = Float.parseFloat(arrItem[3].trim());
				diemck = Float.parseFloat(arrItem[4].trim());
				diemkhac = Float.parseFloat(arrItem[5].trim());
				diemtong = Float.parseFloat(arrItem[6].trim());
				addBangDiem(malop, masv, hoten, diemgk, diemck, diemkhac, diemtong);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public void UpdateBangDiem(String malop, String masv, float diemgk, float diemck, float diemkhac, float diemtong) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			String query = "update BangDiem set diemgk = :diemgk, diemck = :diemck, diemkhac = :diemkhac, diemtong = :diemtong where malop = :malop and masv = :masv";
			session.createQuery(query).setString("malop", malop).setString("masv", masv)
			.setFloat("diemgk", diemgk).setFloat("diemck", diemck)
			.setFloat("diemkhac", diemkhac).setFloat("diemtong", diemtong).executeUpdate();
		
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
}
