package Utils;
// "Activador" Hacer que los botones respondan
import com.raven.event.TableActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionEditor extends DefaultCellEditor {

    private final TableActionEvent event;

    public TableActionEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean isSelected, int row, int column) {
        Action action = new Action();
        action.setBackground(new Color(239, 244, 255));

        action.getCmdEdit().addActionListener(e -> {
            fireEditingStopped(); // Cierra la edición de la celda antes de abrir el diálogo
            event.onEdit(row);
        });

        action.getCmdDelete().addActionListener(e -> {
            fireEditingStopped(); // Cierra la edición antes de borrar la fila para evitar errores de índice
            event.onDelete(row);
        });

        return action;
    }
}
