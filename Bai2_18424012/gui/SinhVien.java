package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.HibernateUtil;
import pojo.BangDiem;
import pojo.SvPhucKhao;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class SinhVien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable tbl_PhucKhao;
	private JLabel lblDanhSchim;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private JMenuItem menuItem_1;
	private JPanel panel;
	private JLabel lblStatus;
	private JList list;
	private JButton btnPhcKho;

	/**
	 * Launch the application.
	 */
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	private JMenuBar menuBar_1;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmPhucKhao;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinhVien frame = new SinhVien();
					frame.setVisible(true);
					
					showAllBangDiem();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SinhVien() {
		
		setTitle("Sinh Viên: " + Services.getData());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 341);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menu = new JMenu("Account");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Logout");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Services sv = new Services();
//				sv.Login_out();
				Login.setVisible_Login();
			}
		});
		menu.add(menuItem);
		
		menuItem_1 = new JMenuItem("Change Password");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Services sv = new Services();
//				sv.ChangePass();
				ChangePassword f = new ChangePassword();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		menu.add(menuItem_1);
		
		mnNewMenu = new JMenu("Diem Thi");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Xem Diem Thi");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowTable(table);
			}
		});
		
		mntmPhucKhao = new JMenuItem("Phuc Khao");
		mntmPhucKhao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowTablePhucKhao(tbl_PhucKhao);
			}
		});
		mnNewMenu.add(mntmPhucKhao);
		mnNewMenu.add(mntmNewMenuItem);
		
		menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(20, 10));
		setContentPane(contentPane);
		Object rows[][] = {{"one", "ichi - \u4E00" },
		        {"two", "ni - \u4E8C" }, {"three", "san - \u4E09" },
		        {"four", "shi - \u56DB" }, {"five", "go - \u4E94" },
		        {"six", "roku - \u516D" }, {"seven", "shichi - \u4E03" },
		        {"eight", "hachi - \u516B" }, {"nine", "kyu - \u4E5D" },
		        {"ten", "ju - \u5341" } };
	    Object headers[] = {"English", "Japanese" };
	    
	    DefaultTableModel model = new DefaultTableModel(headers, 0) {
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

//		table = new JTable(rows, headers);
	    table = new JTable();
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);

		lblDanhSchim = new JLabel("Danh Sách Điểm Thi");
		lblDanhSchim.setForeground(Color.GREEN);
		lblDanhSchim.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblDanhSchim, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(270, 300));
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(10, 10));
		
		lblStatus = new JLabel("Đăng ký Phúc Khảo:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblStatus, BorderLayout.PAGE_START);
		
//		JTable tbl_phuckhao = new JTable(rows, headers);
		tbl_PhucKhao = new JTable();
		panel.add(new JScrollPane(tbl_PhucKhao), BorderLayout.CENTER);
		
		btnPhcKho = new JButton("Phúc Khảo");
		panel.add(btnPhcKho, BorderLayout.SOUTH);
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
	    	model.setValueAt(i + 1, i, 1); // Sá»‘ thá»© tá»±
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
			String query = "from BangDiem where masv = " + Login.user;
			list = session.createQuery(query).list();
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
		return list;
	}
	public void ShowTablePhucKhao(JTable table) {
		Object columns[] = {"", "STT", "Ma Lop", "Trang Thai"};
	    
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
//	    table.getColumnModel().getColumn(2).setMaxWidth(100); // MaSV
	    table.getColumnModel().getColumn(2).setMaxWidth(100); // MaLop 
	    table.getColumnModel().getColumn(3).setMaxWidth(500); // Trang thai
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//	    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Boolean.class);
//	    renderer.setHorizontalAlignment(SwingConstants.RIGHT);
//	    table.setDefaultRenderer(table.getColumnClass(0), renderer);  
	    List<SvPhucKhao> sv = showAllPhucKhao();
	    for(int i = 0; i < sv.size(); i++) {
    		model.addRow(new Object[0]);
	    	model.setValueAt(false, i, 0); // set checkbox
	    	model.setValueAt(i + 1, i, 1); // Sá»‘ thá»© tá»±
//	    	model.setValueAt(sv.get(i).getMasv(), i, 2);
	    	model.setValueAt(sv.get(i).getMalop(), i, 2);
	    	model.setValueAt(sv.get(i).getTrangthai(), i, 3);
	    }
	}
	public static List<SvPhucKhao> showAllPhucKhao() {
		List<SvPhucKhao> list = new ArrayList<>();
		Session session= factory.openSession();
		try{
			session.beginTransaction();
			String query = "from SvPhucKhao";
			list = session.createQuery(query).list();
			for (SvPhucKhao item : list) {
				System.out.println(item.getMasv() + "\t" + item.getMalop()
				+ "\t" + item.getTrangthai());
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
