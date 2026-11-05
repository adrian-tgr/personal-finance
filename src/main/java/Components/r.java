package Components;

import Utils.Model_Card;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

  

    public class r extends javax.swing.JPanel {

        public Color getColor1() {
            return color1;
        }

        public void setColor1(Color color1) {
            this.color1 = color1;
        }

        public Color getColor2() {
            return color2;
        }

        public void setColor2(Color color2) {
            this.color2 = color2;
        }

        private Color color1;
        private Color color2;

        public r() {
            initComponents();
            setOpaque(false);
            color1 = Color.BLACK;
            color2 = Color.WHITE;
        }

        public void setData(Model_Card data) {
            lbIcon.setIcon(data.getIcon());
            lbTitle.setText(data.getTitle()+ " ["+data.getMonth()+")");
            lbCash.setText(String.format("$ %,d", data.getCash()));
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs); // Llamar primero al método base

            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Bordes circulares

            // Dibujar el degradado
            GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
            g2.setPaint(g);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

            // Dibujar círculos decorativos
            g2.setColor(new Color(255, 255, 255, 50));
            g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
            g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());

            g2.dispose(); // Liberar recursos
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbCash = new javax.swing.JLabel();

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flag.png"))); // NOI18N

        lbTitle.setFont(new java.awt.Font("Roboto SemiCondensed", 0, 24)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setText("Title");

        lbCash.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbCash.setForeground(new java.awt.Color(255, 255, 255));
        lbCash.setText("Cash");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lbCash, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addComponent(lbCash, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbCash;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}
