package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.io.File;

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

public class Home extends JFrame {

	private JPanel contentPane;
	Home frame;
	private JTextField txtImport;
	private JTable table;
	private JTextField textField;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
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
		
		Object rows[][] = {{"one", "ichi - \u4E00" },
		        {"two", "ni - \u4E8C" }, {"three", "san - \u4E09" },
		        {"four", "shi - \u56DB" }, {"five", "go - \u4E94" },
		        {"six", "roku - \u516D" }, {"seven", "shichi - \u4E03" },
		        {"eight", "hachi - \u516B" }, {"nine", "kyu - \u4E5D" },
		        {"ten", "ju - \u5341" } };
	    Object headers[] = {"select", "English", "Japanese" };
	    table = new JTable();
	    
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
	    table = new JTable();

	    table.setModel(model);
	    table.setRowHeight(30);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
	    table.getColumnModel().getColumn(0).setMaxWidth(30);
	    table.getColumnModel().getColumn(1).setPreferredWidth(100);
//	    table.getColumnModel().getColumn(2).setPreferredWidth(30);
//	    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//	    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Boolean.class);
//	    renderer.setHorizontalAlignment(SwingConstants.RIGHT);
//	    table.setDefaultRenderer(table.getColumnClass(0), renderer);    
	    System.out.println(rows.length);
	    for(int i = 0; i < rows.length; i++) {
	    	System.out.println(rows[i]);
	    	model.addRow(new Object[0]);
	    	model.setValueAt(false, i, 0);
	    	model.setValueAt(rows[i][0], i, 1);
	    	model.setValueAt(rows[i][1], i, 2);
	    }

//	    DefaultTableModel model = new DefaultTableModel(new Object[][] {
//	        { "some", "text" }, { "any", "text" }, { "even", "more" },
//	        { "text", "strings" }, { "and", "other" }, { "text", "values" } },
//	        new Object[] { "Column 1", "Column 2" });
//		contentPane.add(table, BorderLayout.CENTER);
	    JPanel tablePanel = new JPanel();
	    tablePanel.setLocation(20, 20);
	    tablePanel.setLayout(new BorderLayout());
	    JScrollPane scrollPane = new JScrollPane(table);
	    tablePanel.add(scrollPane, BorderLayout.CENTER);
	    

	    
	    // Vung Page_Start
		
		JPanel page_start = new JPanel();
		page_start.setLayout(new BorderLayout());
//		JButton btn = new JButton("Phuc Khao");
//		btn.setPreferredSize(new Dimension(360, 200));
//		page_start.add(btn, BorderLayout.LINE_START);
		MyCompomentAddSinhVien addSinhVien = new MyCompomentAddSinhVien();
		addSinhVien.setPreferredSize(new Dimension(270, 250));
//		addSinhVien.setPreferredSize(new Dimension(300, 200));
		JLabel lblTitle = new JLabel("Quản Lý Sinh Viên");
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		page_start.add(lblTitle, BorderLayout.PAGE_START);
		page_start.add(addSinhVien, BorderLayout.LINE_START);
		
		MyComponentImport importPanel = new MyComponentImport();
		
		page_start.add(importPanel, BorderLayout.CENTER);
		
		// Vung Line_Start
		
	    JPanel pnlLine_Start = new JPanel();
//	    scrollPane.setRowHeaderView(pnlLine_Start);
	    pnlLine_Start.setLayout(null);
	    pnlLine_Start.setPreferredSize(new Dimension(286, 300));
	    textField = new JTextField();
	    textField.setBounds(114, 42, 165, 23);
	    pnlLine_Start.add(textField);
	    textField.setColumns(10);
	    
	    JList list = new JList();
	    list.setBounds(46, 76, 233, 136);
	    pnlLine_Start.add(list);
	    
	    JLabel lblNewLabel = new JLabel("Search");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel.setBounds(44, 46, 60, 14);
	    pnlLine_Start.add(lblNewLabel);
	    
	    
		contentPane.add(tablePanel, BorderLayout.CENTER);
		
		JButton btnThem = new JButton("Thêm");
		tablePanel.add(btnThem, BorderLayout.NORTH);
		
		JButton btnXoa = new JButton("Xóa");
		tablePanel.add(btnXoa, BorderLayout.SOUTH);
		contentPane.add(page_start, BorderLayout.PAGE_START);
		contentPane.add(pnlLine_Start, BorderLayout.LINE_START);
		
		JButton btnXemDsLop = new JButton("XemDSLop");
		btnXemDsLop.setBounds(190, 11, 89, 23);
		pnlLine_Start.add(btnXemDsLop);
		
		JButton btnXemDiem = new JButton("Xem Điểm");
		btnXemDiem.setBounds(97, 11, 89, 23);
		pnlLine_Start.add(btnXemDiem);
		
		JButton btnTKB = new JButton("Xem TKB");
		btnTKB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTKB.setBounds(4, 11, 89, 23);
		pnlLine_Start.add(btnTKB);
		setMinimumSize(new Dimension(630, 500));
		importPanel.addComponentListener(new ComponentAdapter(){
			
			public void componentResized(ComponentEvent e) {
				//640
				if(contentPane.getWidth() - addSinhVien.getWidth() > 630) {
					addSinhVien.setVisible(true);
					pnlLine_Start.setVisible(true);
				}
				else
				{
					addSinhVien.setVisible(false);
					pnlLine_Start.setVisible(false);
				}
			};
		});
	}
}
