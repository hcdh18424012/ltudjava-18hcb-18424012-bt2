package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class SinhVien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblDanhSchim;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private JMenuItem menuItem_1;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JList list;
	private JButton btnPhcKho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinhVien frame = new SinhVien();
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
	public SinhVien() {
		setTitle("Sinh Viên: " + Services.getData());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 341);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menu = new JMenu("Account");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Logout");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Services sv = new Services();
				sv.Login_out();
			}
		});
		menu.add(menuItem);
		
		menuItem_1 = new JMenuItem("Change Password");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Services sv = new Services();
				sv.ChangePass();
			}
		});
		menu.add(menuItem_1);
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
	    
//	    DefaultTableModel model = new DefaultTableModel(headers, 0) {
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

		table = new JTable(rows, headers);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		
		lblDanhSchim = new JLabel("Danh Sách Điểm Thi");
		lblDanhSchim.setForeground(Color.GREEN);
		lblDanhSchim.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblDanhSchim, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 300));
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(10, 10));
		
		lblNewLabel = new JLabel("Phúc Khảo Điểm Môn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel, BorderLayout.PAGE_START);
		
		JTable tbl_phuckhao = new JTable(rows, headers);
		panel.add(new JScrollPane(tbl_phuckhao), BorderLayout.CENTER);
		
		btnPhcKho = new JButton("Phúc Khảo");
		panel.add(btnPhcKho, BorderLayout.SOUTH);
	}
}
