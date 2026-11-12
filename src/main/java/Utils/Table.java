package Utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.raven.model.ModelTransaction;

public class Table extends JTable {

    public Table() {
        // 1. Configurar exactamente las 4 columnas de la vista
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Descripción", "Fecha", "Monto", "Tipo" }
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false; // Bloquear edición de celdas
            }
        };
        setModel(model);

        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false); // Bloquear el reordenamiento de columnas

        //Renderizador personalizado de la cabecera
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(o + "");
                return header;
            }
        });

        // Renderizador para celdas normales y la columna de Monto
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus,
                    int row, int column) {
                
                // Columna 2: Monto (Formato moneda $ 0.00 alineado a la derecha)
                if (column == 2) { 
                    JLabel label = new JLabel();
                    if (o instanceof Double) {
                        double monto = (Double) o;
                        label.setText(String.format("$ %,.2f", monto));
                    } else {
                        label.setText(o != null ? o.toString() : "");
                    }
                    label.setHorizontalAlignment(JLabel.RIGHT);
                    label.setOpaque(true);
                    
                    if (selected) {
                        label.setBackground(new Color(230, 240, 250));
                        label.setForeground(new Color(15, 89, 140));
                    } else {
                        label.setBackground(Color.WHITE);
                        label.setForeground(new Color(51, 51, 51));
                    }
                    return label;
                }

                // Celdas normales (Descripción, Fecha, Tipo)
                Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, row, column);
                com.setBackground(Color.WHITE);
                setBorder(noFocusBorder);

                if (selected) {
                    com.setForeground(new Color(15, 89, 140));
                } else {
                    com.setForeground(new Color(102, 102, 102));
                }
                return com;
            }
        });
    }

    // Agrega una fila simple de objetos
    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    // Agrega un objeto ModelTransaction transformándolo en 4 celdas
    public void addTransactionRow(ModelTransaction data) {
        addRow(data.toRowTable());
    }

    // Vacía las filas de la tabla antes de refrescar la Pila LIFO
    public void clear() {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.setRowCount(0);
    }
}