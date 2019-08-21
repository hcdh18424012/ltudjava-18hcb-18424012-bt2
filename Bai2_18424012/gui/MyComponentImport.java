package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.io.File;

public class MyComponentImport extends JPanel implements ActionListener{
	//Import
	JPanel importPanel;
	
	JTextArea txtArea;
	JRadioButton rLop;
	JRadioButton rDiem;   
	JRadioButton rTKB;
	ButtonGroup bgroup;
	JPanel radioPanel;
	
	JButton btnChonFile;
	JButton btnImport;
	public MyComponentImport(){
		importPanel = new JPanel();	
		String title = "Import Data";
		Border border = BorderFactory.createTitledBorder(title);
		importPanel.setBorder(border);
		importPanel.setLayout(null);
		importPanel.setPreferredSize(new Dimension(700, 200));
        rLop = new JRadioButton("Danh S\u00E1ch L\u1EDBp", true);
        rLop.setFont(new Font("Arial", Font.PLAIN, 10));
        rLop.setBounds(6, 79, 125, 23);
        rDiem = new JRadioButton("Danh S\u00E1ch \u0110i\u1EC3m");
        rDiem.setFont(new Font("Arial", Font.PLAIN, 10));
        rDiem.setBounds(6, 49, 125, 23);
        rTKB = new JRadioButton("Th\u1EDDi Kh\u00F3a Bi\u1EC3u");
        rTKB.setFont(new Font("Arial", Font.PLAIN, 10));
        rTKB.setBounds(6, 19, 125, 23);

        //... Create a button group and add the buttons.
        bgroup = new ButtonGroup();
        bgroup.add(rLop);
        bgroup.add(rDiem);
        bgroup.add(rTKB);
        
        radioPanel = new JPanel();
        radioPanel.setBounds(447, 69, 137, 115);
        radioPanel.setLayout(null);
        radioPanel.add(rLop);
        radioPanel.add(rDiem);
        radioPanel.add(rTKB);
        //... Add a titled border to the button panel.
        radioPanel.setBorder(BorderFactory.createTitledBorder(
                   BorderFactory.createEtchedBorder(), "Dữ liệu Import ???"));
        importPanel.add(radioPanel);
    		
		btnChonFile = new JButton("New button");
		btnChonFile.addActionListener(this);
		btnChonFile.setBounds(447, 35, 38, 23);
		importPanel.add(btnChonFile);
		
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setBackground(Color.LIGHT_GRAY);
//		txtArea.setBounds(10, 86, 427, 120);
//		txtArea.setPreferredSize(new Dimension(427, 120));
		JScrollPane scroll = new JScrollPane(txtArea);
		scroll.setLocation(10, 77);
		scroll.setSize(427, 103);
		importPanel.add(scroll);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JTextField txtImport = new JTextField();
		txtImport.setBounds(10, 35, 427, 20);
		importPanel.add(txtImport);
		txtImport.setColumns(10);
		
		btnImport = new JButton("Import");
		btnImport.setBounds(495, 35, 89, 23);
		importPanel.add(btnImport);
		setLayout(new BorderLayout());
		add(importPanel, BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Services chonfile = new Services();
		File[] files = chonfile.ChonFile();
		if(files.length > 0) {
			txtArea.append(files[0].toString());
			for(int i = 1; i < files.length; i++)
				txtArea.append("\n" + files[i]);
		}
			
	}
}
