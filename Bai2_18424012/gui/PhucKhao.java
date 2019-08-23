package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PhucKhao extends JFrame {

	private JPanel contentPane;
	private JTextField txtNgayKT;
	private JTextField txtNgayBD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhucKhao frame = new PhucKhao();
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
	public PhucKhao() {
		setTitle("Ph\u00FAc Kh\u1EA3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtNgayBD = new JTextField();
		txtNgayBD.setBounds(125, 45, 108, 20);
		panel.add(txtNgayBD);
		txtNgayBD.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u1EEB Ng\u00E0y");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(43, 48, 72, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnOK = new JButton("OK");
		btnOK.setBounds(144, 107, 89, 23);
		panel.add(btnOK);
		
		JLabel lblNewLabel = new JLabel("\u0110\u1EBFn Ng\u00E0y");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(50, 79, 65, 14);
		panel.add(lblNewLabel);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(52, 107, 89, 23);
		panel.add(btnCancel);
		
		txtNgayKT = new JTextField();
		txtNgayKT.setBounds(125, 76, 108, 20);
		panel.add(txtNgayKT);
		txtNgayKT.setColumns(10);
		panel.setBorder(BorderFactory.createTitledBorder("Thời Gian Phúc Khảo"));
		
		JLabel lblNewLabel_2 = new JLabel("Định dạng theo: dd/mm/yyyy --> Ví dụ: 10/8/2019");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(10, 20, 264, 14);
		panel.add(lblNewLabel_2);
	}
}
