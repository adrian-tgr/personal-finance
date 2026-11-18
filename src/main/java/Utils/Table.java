package Utils;

import Utils.TableActionRender;
import Utils.TableActionEditor;
import com.raven.event.TableActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.raven.model.ModelTransaction;

public class Table extends JTable {

    public Table() {
        configurarColumnas();

        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);

        // Renderizador de cabecera
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                return new TableHeader(o + "");
            }
        });

        // Renderizador para celdas normales y la columna de Monto
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus,
                    int row, int column) {

                if (column == 2) { // Monto
                    JLabel label = new JLabel();
                    if (o instanceof Double) {
                        label.setText(String.format("$ %,.2f", (Double) o));
                    } else {
                        label.setText(o != null ? o.toString() : "");
                    }
                    label.setHorizontalAlignment(JLabel.CENTER);
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

    private void configurarColumnas() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Descripción", "Fecha", "Monto", "Tipo", "Acciones"}
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 4;
            }
        };
        setModel(model);
        setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Proporciones compactas para las 5 columnas
        getColumnModel().getColumn(0).setPreferredWidth(220);
        getColumnModel().getColumn(1).setPreferredWidth(100);
        getColumnModel().getColumn(2).setPreferredWidth(110);
        getColumnModel().getColumn(3).setPreferredWidth(90);

        getColumnModel().getColumn(4).setCellRenderer(new TableActionRender());
        getColumnModel().getColumn(4).setMinWidth(95);
        getColumnModel().getColumn(4).setPreferredWidth(100);
        getColumnModel().getColumn(4).setMaxWidth(110);
    }

    public void setActionEvent(TableActionEvent event) {
        configurarColumnas();
        getColumnModel().getColumn(4).setCellEditor(new TableActionEditor(event));
    }

    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    public void addTransactionRow(ModelTransaction data) {
        addRow(data.toRowTable());
    }

    public void clear() {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.setRowCount(0);
    }
}
