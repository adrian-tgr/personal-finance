package Components;

import Utils.RoundedPanels;
import java.awt.Color;

public class BackGround extends RoundedPanels {

    Color fondoNormal = new Color(224, 236, 248);
    Color fondoHover = new Color(191, 219, 243);

    public BackGround() {
        // 2. Invocamos al constructor de RoundedPanels(radio, colorFondo)
        super(20, new Color(153, 153, 153));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        card1 = new Components.Card();
        card2 = new Components.Card();
        card3 = new Components.Card();
        jSeparator1 = new javax.swing.JSeparator();
        BtIngreso = new javax.swing.JButton();
        BtEgreso = new javax.swing.JButton();
        BtDeshacer = new javax.swing.JButton();

        card1.setColor1(new java.awt.Color(235, 51, 73));
        card1.setColor2(new java.awt.Color(244, 92, 67));

        card2.setColor1(new java.awt.Color(17, 153, 142));
        card2.setColor2(new java.awt.Color(56, 239, 125));

        card3.setColor1(new java.awt.Color(142, 45, 226));
        card3.setColor2(new java.awt.Color(74, 0, 224));

        BtIngreso.setBackground(new java.awt.Color(224, 236, 248));
        BtIngreso.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BtIngreso.setForeground(new java.awt.Color(30, 41, 59));
        BtIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png"))); // NOI18N
        BtIngreso.setText(" Nuevo Ingreso");
        BtIngreso.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BtIngresoMouseMoved(evt);
            }
        });
        BtIngreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtIngresoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtIngresoMouseExited(evt);
            }
        });

        BtEgreso.setBackground(new java.awt.Color(224, 236, 248));
        BtEgreso.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BtEgreso.setForeground(new java.awt.Color(30, 41, 59));
        BtEgreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/less.png"))); // NOI18N
        BtEgreso.setText(" Nuevo Gasto");
        BtEgreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtEgresoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtEgresoMouseExited(evt);
            }
        });
        BtEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEgresoActionPerformed(evt);
            }
        });

        BtDeshacer.setBackground(new java.awt.Color(224, 236, 248));
        BtDeshacer.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BtDeshacer.setForeground(new java.awt.Color(30, 41, 59));
        BtDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/deshacer.png"))); // NOI18N
        BtDeshacer.setText(" Deshacer");
        BtDeshacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtDeshacerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtDeshacerMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(BtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(BtEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(BtDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(404, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEgresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtEgresoActionPerformed

    private void BtIngresoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtIngresoMouseEntered
        BtIngreso.setBackground(fondoHover);
    }//GEN-LAST:event_BtIngresoMouseEntered

    private void BtIngresoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtIngresoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_BtIngresoMouseMoved

    private void BtIngresoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtIngresoMouseExited
        BtIngreso.setBackground(fondoNormal);
    }//GEN-LAST:event_BtIngresoMouseExited

    private void BtEgresoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEgresoMouseEntered
        BtEgreso.setBackground(fondoHover);
    }//GEN-LAST:event_BtEgresoMouseEntered

    private void BtEgresoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEgresoMouseExited
        BtEgreso.setBackground(fondoNormal);
    }//GEN-LAST:event_BtEgresoMouseExited

    private void BtDeshacerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtDeshacerMouseEntered
        BtDeshacer.setBackground(fondoHover);
    }//GEN-LAST:event_BtDeshacerMouseEntered

    private void BtDeshacerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtDeshacerMouseExited
        BtDeshacer.setBackground(fondoNormal);
    }//GEN-LAST:event_BtDeshacerMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtDeshacer;
    private javax.swing.JButton BtEgreso;
    private javax.swing.JButton BtIngreso;
    private Components.Card card1;
    private Components.Card card2;
    private Components.Card card3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
