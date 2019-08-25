package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.transaction.Transactional.TxType;

import dao.UserPassDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField txtNewPass;
	JLabel lblStatus;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtNewPass = new JTextField();
		txtNewPass.setBounds(106, 27, 122, 20);
		panel.add(txtNewPass);
		txtNewPass.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserPassDAO dao = new UserPassDAO();
				String name = Login.user;
				String newpass = txtNewPass.getText();
				dao.UpdatePass(name, newpass);
				lblStatus.setForeground(Color.BLUE);
				lblStatus.setText("Finished Change Password");
				
			}
		});
		btnNewButton.setBounds(109, 58, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New Password:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 30, 89, 14);
		panel.add(lblNewLabel);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(30, 94, 228, 14);
		panel.add(lblStatus);
	}

}
