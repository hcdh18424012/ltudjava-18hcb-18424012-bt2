package dao;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import gui.Services;
import pojo.SinhVien;
import pojo.ThoiKhoaBieu;
public class ThoiKhoaBieuDAO {
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		addThoiKhoaBieu("17HCB","T","Csdl","C32");
	    
	    List<ThoiKhoaBieu> list = null;
	    ThoiKhoaBieuDAO dao = new ThoiKhoaBieuDAO();
//	    dao.showAllThoiKhoaBieu();
	    list = dao.showAll();
	}
	public void showAllThoiKhoaBieu() {
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
	public void addTKBformCSV(String f) {
		HashMap<String, String> map = Services.ReadFileCSV(f.toString());
		// Lay ten file
		Path path = Paths.get(f);
		// Tach ten va phan mo rong
		String []filenames = path.getFileName().toString().split("\\.");
		String title = map.get("title");
		map.remove("title");
		String malop;
		String mamon;
		String tenmon;
		String phonghoc;
//		Kiem tra hop le dong dau tien

		for(String key: map.keySet()) {
//			System.out.println(map.get(key));
			String arrItem[] = map.get(key).split(",");
			try {
				malop = filenames[0].trim() + "-" + arrItem[1];
				mamon = arrItem[1].trim();
				tenmon = arrItem[2].trim();
				phonghoc = arrItem[3].trim();
				addThoiKhoaBieu(malop, mamon, tenmon, phonghoc);
			} catch (Exception e) {
				// TODO: handle exception
			}
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
	public void ShowTable(JTable table) {
		Object columns[] = {"", "STT", "Ma Lop", "Ma Mon", "Ten Mon", "Phong Hoc"};
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
	    table.getColumnModel().getColumn(2).setMaxWidth(100); // MaLop
	    table.getColumnModel().getColumn(3).setMaxWidth(100); // MaMon
	    table.getColumnModel().getColumn(4).setMaxWidth(500); // TenMon
	    table.getColumnModel().getColumn(5).setMaxWidth(100); // Phong Hoc
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//	    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Boolean.class);
//	    renderer.setHorizontalAlignment(SwingConstants.RIGHT);
//	    table.setDefaultRenderer(table.getColumnClass(0), renderer);  
	    List<ThoiKhoaBieu> tkb = showAll();
	    for(int i = 0; i < tkb.size(); i++) {
	    	model.addRow(new Object[0]);
	    	model.setValueAt(false, i, 0); // set checkbox
	    	model.setValueAt(i + 1, i, 1); // Số thứ tự
	    	model.setValueAt(tkb.get(i).getMalop(), i, 2);
	    	model.setValueAt(tkb.get(i).getMamon(), i, 3);
	    	model.setValueAt(tkb.get(i).getTenmon(), i, 4);
	    	model.setValueAt(tkb.get(i).getPhonghoc(), i, 5);
	    }
	}
	public List<ThoiKhoaBieu> showAll() {
		List<ThoiKhoaBieu> list = new ArrayList<>();
		Session session = factory.openSession();
		try{
			
			session.beginTransaction();

			list = session.createQuery("from ThoiKhoaBieu").list();
			for (ThoiKhoaBieu item : list) {
				System.out.println(item.getMalop() + "\t" + item.getMamon());
			}
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return list;
	}
}
