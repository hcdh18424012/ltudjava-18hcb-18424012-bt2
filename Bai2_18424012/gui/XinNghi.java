package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Lop_SinhVienDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XinNghi extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaLop;
	private JTextField txtMaSV;
	private JButton btnXinNghi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XinNghi frame = new XinNghi();
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
	public XinNghi() {
		setTitle("Xin Nghi Hoc");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 260, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtMaLop = new JTextField();
		txtMaLop.setBounds(83, 23, 86, 20);
		panel.add(txtMaLop);
		txtMaLop.setColumns(10);
		
		txtMaSV = new JTextField();
		txtMaSV.setColumns(10);
		txtMaSV.setBounds(83, 54, 86, 20);
		panel.add(txtMaSV);
		
		JLabel lblMaLop = new JLabel("Ma Lop:");
		lblMaLop.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaLop.setBounds(10, 26, 63, 14);
		panel.add(lblMaLop);
		
		JLabel lblMaSv = new JLabel("Ma SV:");
		lblMaSv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaSv.setBounds(10, 57, 63, 14);
		panel.add(lblMaSv);
		
		btnXinNghi = new JButton("Xin Nghi");
		btnXinNghi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lop_SinhVienDAO dao = new Lop_SinhVienDAO();
				String malop = txtMaLop.getText();
				String masv = txtMaSV.getText();
				dao.DeleteLop_Sv(malop, masv);
			}
		});
		btnXinNghi.setBounds(83, 85, 86, 23);
		panel.add(btnXinNghi);
	}

}
