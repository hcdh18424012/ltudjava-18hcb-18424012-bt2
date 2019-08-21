package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;

public class JFtest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFtest frame = new JFtest();
					frame.setTitle("Test");
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
	public JFtest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLayout(new BorderLayout());
		TextArea txtArea = new TextArea();
//		contentPane.add(new JScrollPane(txtArea), BorderLayout.CENTER);
		MyComponentImport mycomponent = new MyComponentImport();
		
		add(mycomponent, BorderLayout.PAGE_START);
		TextPanel txtp = new TextPanel();
		contentPane.add(txtp, BorderLayout.CENTER);
		MyComponentImport mycomponent2 = new MyComponentImport();
		
		add(mycomponent2, BorderLayout.PAGE_END);
	}

}
class TextPanel extends JPanel{
	JTextArea txt;
	public TextPanel(){
		txt = new JTextArea();
		setLayout(new BorderLayout());
		add(new JScrollPane(txt), BorderLayout.CENTER);
	}
}