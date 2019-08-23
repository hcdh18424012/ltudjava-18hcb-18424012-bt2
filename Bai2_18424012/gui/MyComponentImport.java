package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import dao.SinhVienDAO;

import java.io.File;

public class MyComponentImport extends JPanel implements ActionListener{
	//Import
	JPanel importPanel;
	JTextField txtImport;
	JTextArea txtArea;
	JRadioButton rLop;
	JRadioButton rDiem;   
	JRadioButton rTKB;
	ButtonGroup bgroup;
	JPanel radioPanel;
	
	JButton btnChonFile;
	JButton btnImport;
	File[] files;
	static List<String> listFileTxtArea = new ArrayList<>();
	String path = null;
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
    		
		btnChonFile = new JButton("...");
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
		txtImport = new JTextField();
		txtImport.setBounds(10, 35, 427, 20);
		importPanel.add(txtImport);
		txtImport.setColumns(10);
		btnImport = new JButton("Import");
		btnImport.setBounds(495, 35, 89, 23);
		btnImport.addActionListener(this);
		importPanel.add(btnImport);
		
		setLayout(new BorderLayout());
		add(importPanel, BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("...")) {
			Services chonfile = new Services();
			File path_file = new File(txtImport.getText());
			if(path_file.exists())
				path = path_file.toString();
			files = chonfile.ChonFile(path);
			for(File f: files)
				listFileTxtArea.add(f.toString());
			txtArea.setText(setTextArea(listFileTxtArea));
		}
		if(e.getActionCommand().equals("Import")) {
			ImportfileToTable();
			if(rLop.isSelected())
				System.out.println("Import Lop");
			if(rDiem.isSelected())
				System.out.println("Import Diem");
			if(rTKB.isSelected())
				System.out.println("Import TKB");
		}
			
	}
	public void ImportfileToTable() {
		for(File f: files) {
			System.out.println("Đang import: " + f);
			listFileTxtArea.removeIf(s -> s.equals(f.toString()));
			System.out.println(listFileTxtArea.size());
			txtArea.setText(setTextArea(listFileTxtArea));
			SinhVienDAO sinhVienDAO = new SinhVienDAO();
			sinhVienDAO.writeFileSinhVien(f.toString());
		}
	}
	public String setTextArea(List<String> list) {
		String s = "";
		if(list.size() > 0) {
			s += (list.get(0));
			for(int i = 1; i < list.size(); i++)
				s += ("\n" + list.get(i));
			return s;
		}
		return null;
	}
}
