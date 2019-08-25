package dao;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Table;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Query;

import gui.Services;
import pojo.Lop_SinhVien;
import pojo.SinhVien;

public class SinhVienDAO {
	private static String filename; // Dung la lam ten lop
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	public static void main(String[] args) {
		try {	
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub

	}
	public void ShowTable(JTable table) {
		Object columns[] = {"", "STT", "Mã SV", "Họ Tên", "Giới Tính", "CMND"};
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
	    table.getColumnModel().getColumn(3).setMaxWidth(300); // Hoten
	    table.getColumnModel().getColumn(4).setMaxWidth(100); // Gioi Tinh
	    table.getColumnModel().getColumn(5).setMaxWidth(100); // CMND
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//	    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Boolean.class);
//	    renderer.setHorizontalAlignment(SwingConstants.RIGHT);
//	    table.setDefaultRenderer(table.getColumnClass(0), renderer);  
	    List<SinhVien> sv = showAll();
	    for(int i = 0; i < sv.size(); i++) {
	    	model.addRow(new Object[0]);
	    	model.setValueAt(false, i, 0); // set checkbox
	    	model.setValueAt(i + 1, i, 1); // Số thứ tự
	    	model.setValueAt(sv.get(i).getMasv(), i, 2);
	    	model.setValueAt(sv.get(i).getHoten(), i, 3);
	    	model.setValueAt(sv.get(i).getGioitinh(), i, 4);
	    	model.setValueAt(sv.get(i).getCmnd(), i, 5);
	    }
	}
	public void addSinhVienfromCSV(String f) {
		HashMap<String, String> map = Services.ReadFileCSV(f.toString());
		String []path = Paths.get(f).getFileName().toString().split("\\.");
		filename = path[0];
		String title = map.get("title");
		map.remove("title");
		String masv;
		String hoten;
		String gioitinh;
		String cmnd;
//		Kiem tra hop le dong dau tien

		for(String key: map.keySet()) {
//			System.out.println(map.get(key));
			String arrItem[] = map.get(key).split(",");
			try {
				masv = arrItem[1].trim();
				hoten = arrItem[2].trim();
				gioitinh = arrItem[3].trim();
				cmnd = arrItem[4].trim();
				addSinhVien(masv, hoten, gioitinh, cmnd);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public List<SinhVien> showAll() {
		List<SinhVien> list = new ArrayList<>();
		Session session = factory.openSession();
		try{
			
			session.beginTransaction();

			list = session.createQuery("from SinhVien").list();
//			for (SinhVien item : list) {
//				System.out.println(item.getMasv() + "\t" + item.getHoten());
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
	public void addSinhVien(String masv, String hoten, String gioitinh, String cmnd) {
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			String query = "Select masv from SinhVien where masv = :masv";
			System.out.println();
			List<String> masinhvien = session.createQuery(query).setString("masv", masv).list();
			System.out.println("Ma Sinh vien: " + masinhvien);
			if(masinhvien.isEmpty()) {
				System.out.println("Add: " + masv);
				SinhVien new_item = new SinhVien(masv, hoten, gioitinh, cmnd);
				session.save(new_item);
				System.out.println(filename);
				Lop_SinhVien new_lopsv = new Lop_SinhVien(filename + "-" + masv, filename, masv);
				session.save(new_lopsv);

			}
			else 
				if(masinhvien.get(0).equals(masv)) {
				System.out.println("Update: " + masinhvien.get(0));
				String query_update = "update SinhVien set hoten = :hoten, gioitinh = :gioitinh, cmnd = :cmnd where masv = :masv";
				session.createQuery(query_update)
						.setString("hoten", hoten).setString("gioitinh", gioitinh).setString("cmnd", cmnd).setString("masv", masv)
						.executeUpdate();
			}
			session.getTransaction().commit();
			System.out.println("Insert finished");
			session.close();
		} catch (Exception e) {
			System.out.print("Error: " + masv);
//			System.out.println(e);
		}
	}
	
//    public static String Lop(int loai){
//        if(loai == 1)
//            System.out.println("Danh Sách Lớp - Sinh Viên ");
//        if(loai == 2)
//            System.out.println("Danh Sách Lớp - Môn Học");
//        Path des = Paths.get(System.getProperty("user.dir"));
////        System.out.println(des);
//        des = Paths.get(des.getParent() + "/Data/Lop/");
////        System.out.println(des);
//        File dir = new File(des.toString());
//        if(!dir.exists() || dir.list().length == 0){
//            System.out.println("Chưa có bảng điểm");
//            Menu();
//        }
//        File[] files = dir.listFiles();
//        
//        ArrayList<String> listFile = new ArrayList<>();
//        ArrayList<String> listName = new ArrayList<>();
//        for(File f: files){
//            if(f.toString().endsWith(".csv")){
//                String []name = f.getName().split("\\.");
////                System.out.println(name[0]);
//                // Tên lớp
//                if((loai == 1) && !(name[0].contains("-"))){
//                    listName.add(name[0]);
//                    listFile.add(f.toString());
//                }
//                // Tên lớp Môn học
//                if((loai == 2) && (name[0].contains("-"))){
//                    listName.add(name[0]);
//                    listFile.add(f.toString());
//                }
//                      
//                if(loai == 3){
//                    listName.add(name[0]);
//                    listFile.add(f.toString());
//                   
//                }
//            }
//        }
//            
//        for(int i = 0; i < listName.size(); i++){
//            System.out.printf("%d) %s",i + 1, listName.get(i));
//            //System.out.printf("%d. %s", stt, f);
//            System.out.println();
//        }
////        Nếu trong thư mục Lớp tồn tại file thì mới xét
//        
//        if(listFile.size() > 0){
//            System.out.print("Nhập lựa chọn: ");
//            int chon;
//            while(true){
//                Scanner sc = new Scanner(System.in);
//                try {
//                    chon = sc.nextInt();
//                } catch (Exception e) {
//                    System.out.println("Bạn nhập không phải số --> " + e);
//                    continue;
//                }
//                chon = chon - 1;
//                if(chon < listFile.size() && chon >= 0){
//                    path = listFile.get(chon);
//                    break;
//                }
//                else
//                    System.out.print("Nhập lựa chọn: ");
//            }
//            
//        }else
//            System.out.println("Danh Sách Lớp NULL");
//        return path;
//    }
//    public static String Chon_Lop(){
//        Path des = Paths.get(System.getProperty("user.dir"));
////        System.out.println(des);
//        des = Paths.get(des.getParent() + "/Data/Lop/");
////        System.out.println(des);
//        File dir = new File(des.toString());
//        File[] files = dir.listFiles();
//        int stt = 0;
//        ArrayList<String> listFile = new ArrayList<>();
//        for(File f: files){
//            
//            if(f.toString().endsWith(".csv")){
//                listFile.add(stt, f.toString());
//                stt++;
//                String []name = f.getName().split("\\.");
//                System.out.printf("%d. %s", stt, name[0]);
//                //System.out.printf("%d. %s", stt, f);
//                System.out.println();
//            }
//        }
////        Nếu trong thư mục Lớp tồn tại file thì mới xét
//        
//        if(listFile.size() > 0){
//            System.out.print("Nhập lựa chọn: ");
//            int chon;
//            while(true){
//                Scanner sc = new Scanner(System.in);
//                try {
//                    chon = sc.nextInt();
//                } catch (Exception e) {
//                    System.out.println("Bạn nhập không phải số --> " + e);
//                    continue;
//                }
//                chon = chon - 1;
//                if(chon < listFile.size() && chon >= 0){
//                    path = listFile.get(chon);
//                    break;
//                }
//                else
//                    System.out.print("Nhập lựa chọn: ");
//            }
//            
//        }
//        return path;
//    }
//    public static void GiaoVuXemDsLop(){
//        String path = Chon_Lop();
//        FormatDSLop(path);
//    }
}
