package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserPassDAO;
import pojo.UserPass;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.util.Locale;

public class Login extends JFrame {
	private static Login frame;
	public static Home frameHome;
	public static SinhVien frameSinhVien; 
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JLabel lblLogin;
	public static String user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
					frameHome = new Home();
					frameHome.setLocationRelativeTo(null);
					frameHome.setVisible(false);
					
					frameSinhVien = new SinhVien();
					frameSinhVien.setLocationRelativeTo(null);
					frameSinhVien.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(128, 24, 125, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(128, 55, 125, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(50, 27, 68, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(50, 58, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
				lblLogin.setText("");
			}
		});
		btnCancel.setBounds(50, 98, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = txtUsername.getText();
				System.out.println(user);
				String pass = txtPassword.getText();
				
				if(user.equals("") || pass.equals("")){
					lblLogin.setForeground(Color.ORANGE);
					lblLogin.setText("Chưa nhập Username or Password");
				}else
				{
					UserPass userpass = new UserPass(user, pass);
					String s = UserPassDAO.Login(userpass);
					if(s != null) {
						
						Services.setData(user);
						lblLogin.setForeground(Color.BLUE);
//						lblLogin.setText(s +  ": Đăng nhập thành công");
						if(s.equalsIgnoreCase(user)) {
							frame.setVisible(false);
							if(user.equalsIgnoreCase("giaovu")) {
								frameHome.setVisible(true);
								frameHome.setTitle(user);
							}
							else {
								frameSinhVien.setVisible(true);		
								frameSinhVien.setTitle(user);
							}

						}
						else
						{
							lblLogin.setForeground(Color.ORANGE);
							lblLogin.setText("Username or Password không đúng");
						}
					}
				}
			}
		});
		btnLogin.setBounds(164, 98, 89, 23);
		contentPane.add(btnLogin);
		
		lblLogin = new JLabel("");
		lblLogin.setForeground(Color.RED);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(50, 141, 205, 29);
		contentPane.add(lblLogin);
	}
	public static void setVisible_Login(){
		frame.setVisible(true);
		frameSinhVien.setVisible(false);
		frameHome.setVisible(false);
	}
	public boolean ktraLogin() {
		String user = txtUsername.getText();
		System.out.println(user);
		String pass = txtPassword.getText();
		
		if(user.equals("") || pass.equals("")){
			lblLogin.setForeground(Color.ORANGE);
			lblLogin.setText("Chưa nhập Username or Password");
		}else
		{
			UserPass userpass = new UserPass(user, pass);
			String s = UserPassDAO.Login(userpass);
			if(s != null) {
				
				Services.setData(user);
				lblLogin.setForeground(Color.BLUE);
//				lblLogin.setText(s +  ": Đăng nhập thành công");
				if(s.equalsIgnoreCase(user)) {
					frame.setVisible(false);
					if(user.equalsIgnoreCase("giaovu") && pass.equals("giaovu")) {
						frameHome.setVisible(true);
					}
					else {
						frameSinhVien.setVisible(true);					
					}
					return true;
				}
				else
				{
					lblLogin.setForeground(Color.ORANGE);
					lblLogin.setText("Username or Password không đúng");
				}
			}
		}
		return false;
	}
}
