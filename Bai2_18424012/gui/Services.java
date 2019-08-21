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
}
