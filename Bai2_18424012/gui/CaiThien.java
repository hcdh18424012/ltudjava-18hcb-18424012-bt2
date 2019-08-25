package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Lop_SinhVienDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CaiThien extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaLop;
	private JTextField textMaSv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaiThien frame = new CaiThien();
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
	public CaiThien() {
		setTitle("Cai Thien Diem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 253, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtMaLop = new JTextField();
		txtMaLop.setBounds(78, 11, 86, 20);
		panel.add(txtMaLop);
		txtMaLop.setColumns(10);
		
		textMaSv = new JTextField();
		textMaSv.setColumns(10);
		textMaSv.setBounds(78, 42, 86, 20);
		panel.add(textMaSv);
		
		JButton btnCaiThien = new JButton("Cai Thien");
		btnCaiThien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String malop = txtMaLop.getText();
				String masv = textMaSv.getText();
				Lop_SinhVienDAO dao = new Lop_SinhVienDAO();
				dao.InsertLop_Sv(malop, masv);
			}
		});
		btnCaiThien.setBounds(78, 82, 89, 23);
		panel.add(btnCaiThien);
		
		JLabel lblMaLop = new JLabel("Ma Lop");
		lblMaLop.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaLop.setBounds(10, 14, 58, 14);
		panel.add(lblMaLop);
		
		JLabel lblMaSv = new JLabel("Ma SV");
		lblMaSv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaSv.setBounds(10, 45, 58, 14);
		panel.add(lblMaSv);
	}

}
