package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import dao.SinhVienDAO;

class MyCompomentAddSinhVien extends JPanel implements ActionListener {
	JPanel panelMangerSV;
	private JTextField txtMSV;
	private JTextField txtHoTen;
	private JRadioButton rdbtnNu;
	private JRadioButton rdbtnNam;
	private JTextField txtCMND;
	public MyCompomentAddSinhVien() {
		JPanel panelMangerSV = new JPanel();
		
		panelMangerSV.setLayout(null);
		
		txtMSV = new JTextField();
		txtMSV.setBounds(115, 78, 138, 20);
		panelMangerSV.add(txtMSV);
		txtMSV.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(115, 109, 138, 28);
		panelMangerSV.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(115, 185, 138, 20);
		panelMangerSV.add(txtCMND);
		txtCMND.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(164, 216, 89, 23);
		panelMangerSV.add(btnAdd);
		
//		JComboBox cbBoxMaLop = new JComboBox();
//		cbBoxMaLop.setBounds(115, 47, 138, 20);
//		panelMangerSV.add(cbBoxMaLop);
		JTextField txtMaLop = new JTextField();
		txtMaLop.setBounds(115, 47, 138, 20);
		panelMangerSV.add(txtMaLop);
		
		JLabel lblNewLabel = new JLabel("Ma Lop");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 47, 95, 14);
		panelMangerSV.add(lblNewLabel);
		
		JLabel lblMSinhVin = new JLabel("Ma Sinh Vien");
		lblMSinhVin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMSinhVin.setBounds(10, 81, 95, 14);
		panelMangerSV.add(lblMSinhVin);
		
		JLabel lblHTn = new JLabel("Ho Ten");
		lblHTn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHTn.setBounds(10, 116, 95, 14);
		panelMangerSV.add(lblHTn);
		
		JLabel lblGiiTnh = new JLabel("Gioi Tinh");
		lblGiiTnh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiiTnh.setBounds(10, 163, 95, 14);
		panelMangerSV.add(lblGiiTnh);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCmnd.setBounds(10, 188, 95, 14);
		panelMangerSV.add(lblCmnd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(65, 216, 89, 23);
		panelMangerSV.add(btnCancel);
		
		JPanel panel = new JPanel();
		panel.setBounds(115, 136, 138, 44);
		panelMangerSV.add(panel);
		panel.setLayout(null);
		
		rdbtnNu = new JRadioButton("Nu");
		rdbtnNu.setBounds(6, 21, 66, 23);
		panel.add(rdbtnNu);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(74, 21, 58, 23);
		panel.add(rdbtnNam);
		
		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnNam);
		rdbtnGroup.add(rdbtnNu);
		
		JLabel lblThem = new JLabel("Them Sinh Vien");
		lblThem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThem.setForeground(Color.BLUE);
		lblThem.setHorizontalAlignment(SwingConstants.CENTER);
		lblThem.setBounds(24, 11, 255, 25);
		panelMangerSV.add(lblThem);
		setLayout(new BorderLayout());
		add(panelMangerSV, BorderLayout.CENTER);
		Border border = BorderFactory.createTitledBorder("Them Sinh Vien");
		setBorder(border);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SinhVienDAO dao = new SinhVienDAO();
		String masv = txtMSV.getText();
		String hoten = txtHoTen.getText();
		String gioitinh = "";
		if(rdbtnNam.isSelected())
			gioitinh = "Nam";
		else
			gioitinh = "Nữ";
		String cmnd = txtCMND.getText();
		dao.addSinhVien(masv, hoten, gioitinh, cmnd);
		
	}
}
