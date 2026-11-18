package com.raven.component;

import com.raven.event.TableActionEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PanelAction extends javax.swing.JPanel {

    private JButton cmdEdit;
    private JButton cmdDelete;

    public PanelAction() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 8, 2));
        setOpaque(true);

        cmdEdit = crearBotonIcono("/Images/edit.png");
        cmdDelete = crearBotonIcono("/Images/delete.png");

        add(cmdEdit);
        add(cmdDelete);
    }

    private JButton crearBotonIcono(String rutaIcono) {
        JButton btn = new JButton();
        btn.setIcon(new ImageIcon(getClass().getResource(rutaIcono)));
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        return btn;
    }

    public void initEvent(TableActionEvent event, int row) {
        cmdEdit.addActionListener((ActionEvent ae) -> event.onEdit(row));
        cmdDelete.addActionListener((ActionEvent ae) -> event.onDelete(row));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
