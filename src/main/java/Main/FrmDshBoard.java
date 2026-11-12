package Main;

import Dao.TransactionDao;
import Model.User;
import Utils.Estructurs.Pila;
import com.raven.model.ModelTransaction;

//FRAME CENTRAL, CENTRO DE LA APLICACIÓN
public class FrmDshBoard extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmDshBoard.class.getName());
    private final TransactionDao transactionDao = new TransactionDao();
    private final Pila<ModelTransaction> pilaTransacciones = new Pila<>();
    private User usuarioLogueado; // El usuario que inició sesión
    private int xMouse, yMouse;

    public FrmDshBoard() {
        initComponents();
        //Fondo transparente
        setBackground(new java.awt.Color(0, 0, 0, 0));

        //Desactivar opacidad
        this.getRootPane().setOpaque(false);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backGround2 = new Components.BackGround();
        header1 = new Components.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(backGround2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, 700));
        jPanel1.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmDshBoard().setVisible(true));
    }

    // Usuario que inició sesión
    private User usuarioActual;

    // Constructor que recibe al usuario
    public FrmDshBoard(User usuario) {
        this.usuarioActual = usuario;

        // Personalización de bienvenida
        setTitle("Panel Principal - Finanzas Personales");
        setLocationRelativeTo(null);
        mostrarBienvenida();
    }

    private void mostrarBienvenida() {
        if (usuarioActual != null) {
            System.out.println("Sesión iniciada por: " + usuarioActual.getNombre());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.BackGround backGround2;
    private Components.Header header1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
