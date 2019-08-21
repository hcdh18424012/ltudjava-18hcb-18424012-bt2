package gui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Services {
	public File[] ChonFile(){
		JFileChooser fileopen = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Chọn .csv files", "csv");
	    fileopen.addChoosableFileFilter(filter);
	    fileopen.setMultiSelectionEnabled(true);
	    int ret = fileopen.showDialog(null, "Open file");
	    
	    if (ret == JFileChooser.APPROVE_OPTION) {
		    File[] files = fileopen.getSelectedFiles();
		    return files;
	    }
	    return null;
	}
	public void Login_out() {
		System.out.println("Services Logout");
	}
	public void ChangePass() {
		System.out.println("Services Change password");
	}
	public void XemDiemThi() {
		System.out.println("Services Xem Diem Thi");
	}
	public void SuaDiemThi() {
		System.out.println("Services Sửa Diem Thi");
	}
	public void DangKyCaiThien() {
		System.out.println("Services Dang Ky Cai Thien");
	}
	public void XinNghi() {
		System.out.println("Services Xin Nghỉ Học");
	}
}
