package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import dao.BangDiemDAO;
import dao.SinhVienDAO;
import dao.ThoiKhoaBieuDAO;
import pojo.SinhVien;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField textSearch;
	public static JTable tbl_List;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void TestGui() {}
	public Home() {
		setTitle("Home: " + Services.getData());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 869, 608);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Account");
		menuBar.add(mnMenu);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Login / Logout");
				Login.setVisible_Login();
			}
		});
		mnMenu.add(mntmLogout);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change PassWord");
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Change Password actionPerformed");
				ChangePassword f = new ChangePassword();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		mntmChangePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Change Password");
			}
		});
		mnMenu.add(mntmChangePassword);
		
		JMenu mnQLDiem = new JMenu("Quản Lý Điểm");
		menuBar.add(mnQLDiem);
		
		JMenuItem mntmSuaDiem = new JMenuItem("Sửa Điểm");
		mntmSuaDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaDiem suadiem = new SuaDiem();
				suadiem.setVisible(true);
			}
			
		});
		mnQLDiem.add(mntmSuaDiem);
		
		JMenu mnDangKyCT = new JMenu("ĐK Cải Thiện");
		menuBar.add(mnDangKyCT);
		
		JMenuItem mntmXinNghi = new JMenuItem("Xin Nghỉ");
		mntmXinNghi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XinNghi f = new XinNghi();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		mnDangKyCT.add(mntmXinNghi);
		
		JMenuItem mntmXinCaiThien = new JMenuItem("Xin Cải Thiện");
		mntmXinCaiThien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaiThien f = new CaiThien();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		mnDangKyCT.add(mntmXinCaiThien);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		
//		JPanel importPanel = new JPanel();
//			
//			String title = "Import Data";
//			Border border = BorderFactory.createTitledBorder(title);
//			importPanel.setBorder(border);
//			importPanel.setLayout(null);
//			importPanel.setPreferredSize(new Dimension(700, 200));
//			contentPane.add(importPanel, BorderLayout.PAGE_START);
//	        JRadioButton rLop   = new JRadioButton("Danh S\u00E1ch L\u1EDBp", true);
//	        rLop.setFont(new Font("Arial", Font.PLAIN, 10));
//	        rLop.setBounds(6, 79, 125, 23);
//	        JRadioButton rDiem    = new JRadioButton("Danh S\u00E1ch \u0110i\u1EC3m");
//	        rDiem.setFont(new Font("Arial", Font.PLAIN, 10));
//	        rDiem.setBounds(6, 49, 125, 23);
//	        JRadioButton rTKB = new JRadioButton("Th\u1EDDi Kh\u00F3a Bi\u1EC3u");
//	        rTKB.setFont(new Font("Arial", Font.PLAIN, 10));
//	        rTKB.setBounds(6, 19, 125, 23);
//	
//	        //... Create a button group and add the buttons.
//	        ButtonGroup bgroup = new ButtonGroup();
//	        bgroup.add(rLop);
//	        bgroup.add(rDiem);
//	        bgroup.add(rTKB);
//	        
//	        JPanel radioPanel = new JPanel();
//	        radioPanel.setBounds(447, 69, 137, 115);
//	        radioPanel.setLayout(null);
//	        radioPanel.add(rLop);
//	        radioPanel.add(rDiem);
//	        radioPanel.add(rTKB);
//	        //... Add a titled border to the button panel.
//	        radioPanel.setBorder(BorderFactory.createTitledBorder(
//	                   BorderFactory.createEtchedBorder(), "Dữ liệu Import ???"));
//	        importPanel.add(radioPanel);
//        		
//			JButton btnChonFile = new JButton("New button");
//			btnChonFile.setBounds(447, 35, 38, 23);
//			importPanel.add(btnChonFile);
//			
//			JTextArea txtArea = new JTextArea();
//			txtArea.setBounds(10, 74, 427, 104);
//			JScrollPane scroll = new JScrollPane(txtArea);
//			scroll.setLocation(10, 63);
//			scroll.setSize(427, 103);
//			importPanel.add(scroll);
//			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//			txtImport = new JTextField();
//			txtImport.setBounds(10, 35, 427, 20);
//			importPanel.add(txtImport);
//			txtImport.setColumns(10);
//			
//			JButton btnImport = new JButton("Import");
//			btnImport.setBounds(495, 35, 89, 23);
//			importPanel.add(btnImport);
//		
//		Object rows[][] = {{"one", "ichi - \u4E00" },
//		        {"two", "ni - \u4E8C" }, {"three", "san - \u4E09" },
//		        {"four", "shi - \u56DB" }, {"five", "go - \u4E94" },
//		        {"six", "roku - \u516D" }, {"seven", "shichi - \u4E03" },
//		        {"eight", "hachi - \u516B" }, {"nine", "kyu - \u4E5D" },
//		        {"ten", "ju - \u5341" } };
//	    Object headers[] = {"select", "English", "Japanese" };
		
//	    System.out.println(rows.length);
//	    for(int i = 0; i < rows.length; i++) {
//	    	System.out.println(rows[i]);
//	    	model.addRow(new Object[0]);
//	    	model.setValueAt(false, i, 0);
//	    	model.setValueAt(rows[i][0], i, 1);
//	    	model.setValueAt(rows[i][1], i, 2);
//	    }

//	    DefaultTableModel model = new DefaultTableModel(new Object[][] {
//	        { "some", "text" }, { "any", "text" }, { "even", "more" },
//	        { "text", "strings" }, { "and", "other" }, { "text", "values" } },
//	        new Object[] { "Column 1", "Column 2" });
//		contentPane.add(table, BorderLayout.CENTER);
		
		
		
	    JPanel tablePanel = new JPanel();
	    tablePanel.setLocation(20, 20);
	    tablePanel.setLayout(new BorderLayout());
//	    JScrollPane scrollPane = new JScrollPane(table);
//	    tablePanel.add(scrollPane, BorderLayout.CENTER);
	    JTable table = new JTable();
	    tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
	    JLabel lbl = new JLabel("Danh Sách Sinh Viên");
	    tablePanel.add(lbl, BorderLayout.PAGE_START);
//	    Object columns[] = {"", "STT", "Mã SV", "Họ Tên", "Giới Tính", "CMND"};
	    
//	    DefaultTableModel model = new DefaultTableModel(columns, 0) {
//	    	public Class<?> getColumnClass(int column)
//	    	{
//	    		switch(column)
//	    		{
//	    			case 0: 
//	    				return Boolean.class;
//
//	    			default: return String.class;
//	    		}
//	    	}
//	    };
//
//	    table.setModel(model);
//	    table.setRowHeight(30);
//	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
//	    table.getColumnModel().getColumn(0).setMaxWidth(30);
//	    // STT
//	    table.getColumnModel().getColumn(1).setMaxWidth(50);
//	    table.getColumnModel().getColumn(2).setMaxWidth(100); // MaSV
//	    table.getColumnModel().getColumn(3).setMaxWidth(300); // Hoten
//	    table.getColumnModel().getColumn(4).setMaxWidth(100); // Gioi Tinh
//	    table.getColumnModel().getColumn(5).setMaxWidth(100); // CMND
//	    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//	    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Boolean.class);
//	    renderer.setHorizontalAlignment(SwingConstants.RIGHT);
//	    table.setDefaultRenderer(table.getColumnClass(0), renderer);  
//	    SinhVienDAO svDAO1 = new SinhVienDAO();
//	    List<SinhVien> sv = svDAO1.showAll();
//	    for(int i = 0; i < sv.size(); i++) {
//	    	model.addRow(new Object[0]);
//	    	model.setValueAt(false, i, 0); // set checkbox
//	    	model.setValueAt(i + 1, i, 1); // Số thứ tự
//	    	model.setValueAt(sv.get(i).getMasv(), i, 2);
//	    	model.setValueAt(sv.get(i).getHoten(), i, 3);
//	    	model.setValueAt(sv.get(i).getGioitinh(), i, 4);
//	    	model.setValueAt(sv.get(i).getCmnd(), i, 5);
//	    }

	    
	    // Vung Page_Start
		
		JPanel page_start = new JPanel();
		page_start.setLayout(new BorderLayout());
//		JButton btn = new JButton("Phuc Khao");
//		btn.setPreferredSize(new Dimension(360, 200));
//		page_start.add(btn, BorderLayout.LINE_START);
		MyCompomentAddSinhVien addSinhVien = new MyCompomentAddSinhVien();
		addSinhVien.setPreferredSize(new Dimension(280, 265));
//		addSinhVien.setPreferredSize(new Dimension(300, 200));
		JLabel lblTitle = new JLabel("Quản Lý Sinh Viên");
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		page_start.add(lblTitle, BorderLayout.PAGE_START);
		page_start.add(addSinhVien, BorderLayout.LINE_START);
		
		MyComponentImport importPanel = new MyComponentImport();
		
		page_start.add(importPanel, BorderLayout.CENTER);
		
		// Vung Line_Start
		
	    JPanel pnlLine_End = new JPanel();
	    pnlLine_End.setPreferredSize(new Dimension(280, 300));
	    pnlLine_End.setLayout(new BorderLayout(0, 0));
	    
	    
		contentPane.add(tablePanel, BorderLayout.CENTER);
		contentPane.add(page_start, BorderLayout.PAGE_START);
		contentPane.add(pnlLine_End, BorderLayout.LINE_END);
		
		JPanel panel_1 = new JPanel();
		pnlLine_End.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(lblNewLabel); 
		
		textSearch = new JTextField();
		panel_1.add(textSearch);
		textSearch.setColumns(20);
//		textSearch.setText();
		tbl_List = new JTable();
		pnlLine_End.add(new JScrollPane(tbl_List), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnXemDiem = new JButton("Xem Điểm");
		btnXemDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BangDiemDAO dao = new BangDiemDAO();
				dao.ShowTable(table);
			}
		});
		
		JButton btnTKB = new JButton("Xem TKB");
		panel.add(btnTKB);
		btnTKB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThoiKhoaBieuDAO dao = new ThoiKhoaBieuDAO();
				dao.ShowTable(table);
			}
		});
		panel.add(btnXemDiem);
		
		JButton btnXemDsLop = new JButton("XemDSLop");
		btnXemDsLop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinhVienDAO dao = new SinhVienDAO();
				dao.ShowTable(table);
			}
		});
		panel.add(btnXemDsLop);
		
		JButton btnPhucKhao = new JButton("Phúc Khảo");
		btnPhucKhao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhucKhao f = new PhucKhao();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		panel.add(btnPhucKhao);
		
		JButton btnAnHien = new JButton("Show/Hide Page_Start");
		btnAnHien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(page_start.isVisible())
					page_start.setVisible(false);
				else
					page_start.setVisible(true);
			}
		});
		panel.add(btnAnHien);
		setMinimumSize(new Dimension(630, 500));
		importPanel.addComponentListener(new ComponentAdapter(){
			
			public void componentResized(ComponentEvent e) {
				//640
				if(contentPane.getWidth() - addSinhVien.getWidth() > 630) {
					addSinhVien.setVisible(true);
					pnlLine_End.setVisible(true);
				}
				else
				{
					addSinhVien.setVisible(false);
					pnlLine_End.setVisible(false);
				}
			};
		});
	}
}
