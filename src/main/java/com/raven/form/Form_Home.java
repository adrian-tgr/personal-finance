package com.raven.form;

import Dao.TransactionDao;
import Utils.DlgTransaction;
import Utils.Estructurs.Pila;
import com.raven.dialog.Message;
import Main.Main;
import com.raven.model.ModelCard;
import com.raven.model.ModelTransaction;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.table.EventAction;
import java.awt.Color;
import java.awt.Frame;
import java.util.List;
import javax.swing.Icon;
import javax.swing.SwingUtilities;

public class Form_Home extends javax.swing.JPanel {

    private final java.awt.Color fondoNormal = new java.awt.Color(224, 236, 248); //Colores Hover
    private final java.awt.Color fondoHover = new java.awt.Color(191, 219, 243);
    private final Pila<ModelTransaction> pilaTransacciones = new Pila<>();
    private final TransactionDao transactionDao = new TransactionDao();
    private EventAction eventAction;

    public Form_Home() {
        initComponents();
        configurarHover(BtnIngreso);
        configurarHover(BtnEgreso);
        configurarHover(BtnDeshacer);
        table1.fixTable(jScrollPane1);
        setOpaque(false);
        initEventAction();
        cargarTransaccionesIniciales();
    }

    private void initEventAction() {
        eventAction = new EventAction() {
            @Override
            public void delete(ModelTransaction transaction) {
                if (table1.isEditing()) {
                    table1.getCellEditor().stopCellEditing();
                }
                if (showMessage("¿Eliminar la transacción \"" + transaction.getDescription() + "\"?")) {
                    int index = pilaTransacciones.aLista().indexOf(transaction);
                    if (index != -1 && pilaTransacciones.eliminarPorIndice(index)) {
                        if (transaction.getId() > 0) {
                            transactionDao.eliminar(transaction.getId());
                        }
                        actualizarTablaDesdePila();
                    }
                }
            }

            @Override
            public void update(ModelTransaction transaction) {
                if (table1.isEditing()) {
                    table1.getCellEditor().stopCellEditing();
                }
                int index = pilaTransacciones.aLista().indexOf(transaction);
                if (index == -1) {
                    return;
                }
                Frame parent = (Frame) SwingUtilities.getWindowAncestor(Form_Home.this);
                DlgTransaction dialog = new DlgTransaction(parent, true, transaction);
                dialog.setVisible(true);

                ModelTransaction editada = dialog.getTransaccionGuardada();
                if (editada != null && pilaTransacciones.actualizarPorIndice(index, editada)) {
                    if (editada.getId() > 0) {
                        transactionDao.actualizar(editada);
                    }
                    actualizarTablaDesdePila();
                }
            }
        };
    }

    private void cargarTransaccionesIniciales() {
        List<ModelTransaction> listaBD = transactionDao.listar();
        for (ModelTransaction t : listaBD) {
            pilaTransacciones.push(t);
        }
        actualizarTablaDesdePila();
    }

    private void actualizarTablaDesdePila() {
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table1.getModel();
    model.setRowCount(0);
    List<ModelTransaction> lista = pilaTransacciones.aLista();
    for (ModelTransaction t : lista) {
        table1.addRow(t.toRowTable(eventAction));
    }
    actualizarTarjetasResumen(lista);
}

    private void actualizarTarjetasResumen(List<ModelTransaction> lista) {
        double totalIngresos = 0;
        double totalGastos = 0;

        for (ModelTransaction t : lista) {
            if ("Ingreso".equalsIgnoreCase(t.getType())) {
                totalIngresos += t.getAmount();
            } else if ("Gasto".equalsIgnoreCase(t.getType())) {
                totalGastos += t.getAmount();
            }
        }
        double balance = totalIngresos - totalGastos;

        Icon iconBalance = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.ACCOUNT_BALANCE_WALLET, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        Icon iconIngreso = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.TRENDING_UP, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        Icon iconGasto = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.TRENDING_DOWN, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));

        card1.setData(new ModelCard("Balance", balance, iconBalance));
        card2.setData(new ModelCard("Ingresos", totalIngresos, iconIngreso));
        card3.setData(new ModelCard("Gastos", totalGastos, iconGasto));
    }

    public void deshacerUltimaTransaccion() {
        if (pilaTransacciones.Vacia()) {
            showMessage("No hay transacciones recientes para deshacer.");
            return;
        }
        ModelTransaction desapilada = pilaTransacciones.pop();
        if (desapilada.getId() > 0) {
            transactionDao.eliminar(desapilada.getId());
        }
        actualizarTablaDesdePila();
    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        card1 = new com.raven.component.Card();
        card2 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        BtnIngreso = new javax.swing.JButton();
        BtnEgreso = new javax.swing.JButton();
        BtnDeshacer = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Home");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Historial de Transacciones");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Fecha", "Monto", "Tipo", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );

        card1.setBackground(new java.awt.Color(45, 20, 165));
        card1.setColorGradient(new java.awt.Color(59, 130, 246));
        card1.setMinimumSize(new java.awt.Dimension(0, 114));

        card2.setBackground(new java.awt.Color(27, 54, 93));
        card2.setColorGradient(new java.awt.Color(13, 122, 114));
        card2.setEnabled(false);
        card2.setMinimumSize(new java.awt.Dimension(0, 114));

        card3.setBackground(new java.awt.Color(190, 24, 55));
        card3.setColorGradient(new java.awt.Color(255, 212, 99));
        card3.setMinimumSize(new java.awt.Dimension(0, 114));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(76, 76, 76));
        jLabel6.setText("Acciones Rapidas");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        BtnIngreso.setBackground(new java.awt.Color(153, 153, 153));
        BtnIngreso.setFont(new java.awt.Font("Roboto Condensed ExtraBold", 0, 14)); // NOI18N
        BtnIngreso.setForeground(new java.awt.Color(30, 41, 59));
        BtnIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png"))); // NOI18N
        BtnIngreso.setText("Nuevo Ingreso");
        BtnIngreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnIngreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnIngresoMouseEntered(evt);
            }
        });
        BtnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresoActionPerformed(evt);
            }
        });

        BtnEgreso.setBackground(new java.awt.Color(153, 153, 153));
        BtnEgreso.setFont(new java.awt.Font("Roboto SemiCondensed Black", 1, 14)); // NOI18N
        BtnEgreso.setForeground(new java.awt.Color(30, 41, 59));
        BtnEgreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/less.png"))); // NOI18N
        BtnEgreso.setText("Nuevo Egreso");
        BtnEgreso.setToolTipText("");
        BtnEgreso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEgresoActionPerformed(evt);
            }
        });

        BtnDeshacer.setBackground(new java.awt.Color(153, 153, 153));
        BtnDeshacer.setFont(new java.awt.Font("Roboto SemiCondensed ExtraBold", 1, 14)); // NOI18N
        BtnDeshacer.setForeground(new java.awt.Color(30, 41, 59));
        BtnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/deshacer.png"))); // NOI18N
        BtnDeshacer.setText("Deshacer");
        BtnDeshacer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeshacerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(BtnIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addGap(70, 70, 70)
                        .addComponent(BtnEgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addGap(70, 70, 70)
                        .addComponent(BtnDeshacer, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void configurarHover(javax.swing.JButton boton) {
        boton.setBackground(fondoNormal);
        boton.setFocusPainted(false);
        boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(fondoHover);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(fondoNormal);
            }
        });
    }
    private void BtnEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEgresoActionPerformed
        abrirFormularioModal("Gasto");
    }//GEN-LAST:event_BtnEgresoActionPerformed

    private void BtnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeshacerActionPerformed
        deshacerUltimaTransaccion();
    }//GEN-LAST:event_BtnDeshacerActionPerformed

    private void BtnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresoActionPerformed
        abrirFormularioModal("Ingreso");
    }//GEN-LAST:event_BtnIngresoActionPerformed

    private void BtnIngresoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIngresoMouseEntered
        BtnIngreso.setBackground(fondoHover);
    }//GEN-LAST:event_BtnIngresoMouseEntered

    private void abrirFormularioModal(String tipo) {
    java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
    Utils.DlgTransaction dialog = new Utils.DlgTransaction(parentFrame, true, tipo);
    dialog.setVisible(true);

    com.raven.model.ModelTransaction nueva = dialog.getTransaccionGuardada();
    if (nueva != null && transactionDao.agregar(nueva)) {
        pilaTransacciones.push(nueva);
        actualizarTablaDesdePila();
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDeshacer;
    private javax.swing.JButton BtnEgreso;
    private javax.swing.JButton BtnIngreso;
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private com.raven.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
