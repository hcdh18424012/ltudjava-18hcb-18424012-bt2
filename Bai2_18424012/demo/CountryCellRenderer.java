package demo;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class CountryCellRenderer extends JLabel implements TableCellRenderer{
    public static int currentRow = -1;
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    	if(row%2 != 0){
            this.setBackground(Color.GRAY);
        }else{
            this.setBackground(Color.CYAN);
        }
        if(row == currentRow)
            this.setBackground(new Color(250, 250, 250));
//        this.setOpaque(true);
        this.setText(value.toString());
        return this;
    }
}
