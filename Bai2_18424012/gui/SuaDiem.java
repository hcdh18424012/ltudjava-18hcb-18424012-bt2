package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.BangDiemDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class SuaDiem extends JFrame {

	private JPanel contentPane;
	private JTextField txtGK;
	private JTextField txtCK;
	private JTextField txtDiemTong;
	private JTextField txtDiemKhac;
	private JTextField txtmalop;
	private JTextField txtmasv;
	private JLabel lblStatus;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuaDiem frame = new SuaDiem();
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
	public SuaDiem() {
		setTitle("Sua Diem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 304, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BangDiemDAO dao = new BangDiemDAO();
				try {
					String malop = txtmalop.getText();
					String masv = txtmasv.getText();
					float diemgk = Float.parseFloat(txtGK.getText().trim());
					float diemck = Float.parseFloat(txtCK.getText());
					float diemkhac = Float.parseFloat(txtDiemKhac.getText().trim());
					float diemtong = Float.parseFloat(txtDiemTong.getText().trim());
					dao.UpdateBangDiem(malop, masv, diemgk, diemck, diemkhac, diemtong);
					lblStatus.setForeground(Color.BLUE);
					lblStatus.setText("Hoan Thanh Sua Diem SV");
				} catch (Exception e2) {
					// TODO: handle exception
					lblStatus.setForeground(Color.RED);
					lblStatus.setText("Khong thanh cong");
				}
				
			}
		});
		btnNewButton.setBounds(174, 175, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Lop Mon Hoc");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 23, 90, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ma SV:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(42, 56, 58, 14);
		panel.add(lblNewLabel_1);
		
		txtGK = new JTextField();
		txtGK.setBounds(103, 86, 46, 20);
		panel.add(txtGK);
		txtGK.setColumns(10);
		
		txtCK = new JTextField();
		txtCK.setBounds(217, 87, 46, 20);
		panel.add(txtCK);
		txtCK.setColumns(10);
		
		txtDiemTong = new JTextField();
		txtDiemTong.setBounds(103, 144, 160, 20);
		panel.add(txtDiemTong);
		txtDiemTong.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Diem GK:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(42, 89, 58, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblDiemCk = new JLabel("Diem CK:");
		lblDiemCk.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiemCk.setBounds(159, 89, 58, 14);
		panel.add(lblDiemCk);
		
		JLabel lblDiemTong = new JLabel("Diem Tong:");
		lblDiemTong.setForeground(Color.RED);
		lblDiemTong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDiemTong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiemTong.setBounds(31, 147, 69, 14);
		panel.add(lblDiemTong);
		
		JLabel lblDiemKhac = new JLabel("Diem Khac:");
		lblDiemKhac.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiemKhac.setBounds(21, 122, 79, 14);
		panel.add(lblDiemKhac);
		
		txtDiemKhac = new JTextField();
		txtDiemKhac.setColumns(10);
		txtDiemKhac.setBounds(103, 119, 160, 20);
		panel.add(txtDiemKhac);
		
		txtmalop = new JTextField();
		txtmalop.setColumns(10);
		txtmalop.setBounds(103, 20, 160, 20);
		panel.add(txtmalop);
		
		txtmasv = new JTextField();
		txtmasv.setColumns(10);
		txtmasv.setBounds(103, 53, 160, 20);
		panel.add(txtmasv);
		
		lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setForeground(Color.GREEN);
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setBounds(10, 175, 166, 23);
		panel.add(lblStatus);
	}
}
