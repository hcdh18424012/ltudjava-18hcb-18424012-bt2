package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pojo.PhucKhao;
import pojo.ThoiKhoaBieu;

public class PhucKhaoDAO {
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhucKhaoDAO dao = new PhucKhaoDAO();
		dao.showAllPhucKhao();
	}
	public void ShowTablePhucKhao(JTable table) {
		Object columns[] = {"", "STT", "Ma Mon", "Ngay Bat Dau", "Ngay Ket Thuc"};
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
	    table.getColumnModel().getColumn(3).setMaxWidth(200); // Ngay BD
	    table.getColumnModel().getColumn(4).setMaxWidth(200); // Ngay KT
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//	    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Boolean.class);
//	    renderer.setHorizontalAlignment(SwingConstants.RIGHT);
//	    table.setDefaultRenderer(table.getColumnClass(0), renderer);  
	    List<PhucKhao> phuckhao = showAllPhucKhao();
	    for(int i = 0; i < phuckhao.size(); i++) {
	    	model.addRow(new Object[0]);
	    	model.setValueAt(false, i, 0); // set checkbox
	    	model.setValueAt(i + 1, i, 1); // Số thứ tự
	    	model.setValueAt(phuckhao.get(i).getMalop(), i, 2);
	    	model.setValueAt(phuckhao.get(i).getNgaybatdau(), i, 3);
	    	model.setValueAt(phuckhao.get(i).getNgayketthuc(), i, 4);
	    }
	}
	public List<PhucKhao> showAllPhucKhao() {
		List<PhucKhao> list = new ArrayList<>();
		Session session = factory.openSession();
		try{
			
			session.beginTransaction();

			list = session.createQuery("from phuckhao").list();
			for (PhucKhao item : list) {
				System.out.println(item.getMalop() + "\t" + item.getNgaybatdau() + "\t" + item.getNgayketthuc() );
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
