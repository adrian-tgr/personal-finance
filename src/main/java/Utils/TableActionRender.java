package Utils;
//Dibular los botones en el historial de transacciones

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableActionRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(jtable, o, isSelected, hasFocus, row, column);

        Action action = new Action();
        if (isSelected) {
            action.setBackground(com.getBackground());
        } else {
            action.setBackground(Color.WHITE);
        }
        return action;
    }
}
