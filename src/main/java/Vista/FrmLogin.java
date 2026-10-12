package Vista;

import java.awt.Color;
import Dao.UserDAO;
import Model.User;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrmLogin extends javax.swing.JFrame {

    int xMouse, yMouse;
    private UserDAO userDAO; // Instancia de la capa DAO
    private boolean passVisible = false;

    public FrmLogin() {
        initComponents();
        userTxt.setForeground(new Color(153, 153, 153));
        passTxt.setForeground(new Color(153, 153, 153));
        this.setLocationRelativeTo(null); // Centra la ventana en pantalla
        this.userDAO = new UserDAO();     // Inicializa la conexión a la BD

        passTxt.setEchoChar((char) 0); //No contraseña

        bg.setFocusable(true);
        bg.requestFocusInWindow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        logoname = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        citybg = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        favicon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        RegisLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        loginBtn = new javax.swing.JPanel();
        loginBtnTxt = new javax.swing.JLabel();
        userLabel1 = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        eyeBtn = new javax.swing.JLabel();
        passTxt = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(204, 204, 204));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoname.setBackground(new java.awt.Color(255, 255, 255));
        logoname.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        logoname.setForeground(new java.awt.Color(255, 255, 255));
        logoname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoname.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        bg.add(logoname, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 300, 240));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/city.png"))); // NOI18N
        bg.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 300, 500));

        citybg.setBackground(new java.awt.Color(0, 134, 190));
        citybg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/city.png"))); // NOI18N
        bg.add(citybg, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 0, -1, 500));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setFont(new java.awt.Font("Roboto SemiBold", 1, 24)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(102, 102, 102));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 800, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 40));

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setForeground(new java.awt.Color(0, 0, 0));
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/favicon.png"))); // NOI18N
        favicon.setText("LOGO");
        bg.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setText("INICIAR SESIÓN");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        RegisLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        RegisLabel.setForeground(new java.awt.Color(102, 102, 102));
        RegisLabel.setText("Aun no tengo una cuenta");
        RegisLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegisLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegisLabelMouseExited(evt);
            }
        });
        bg.add(RegisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 410, 20));

        passLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        passLabel.setForeground(new java.awt.Color(0, 0, 0));
        passLabel.setText("CONTRASEÑA");
        bg.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 410, 20));

        loginBtn.setBackground(new java.awt.Color(0, 134, 190));
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
        });

        loginBtnTxt.setBackground(new java.awt.Color(102, 102, 102));
        loginBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        loginBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnTxt.setText("ENTRAR");
        loginBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginBtnLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(loginBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loginBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 330, 40));

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setForeground(new java.awt.Color(0, 0, 0));
        userLabel1.setText("USUARIO");
        bg.add(userLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        userTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(153, 153, 153));
        userTxt.setText("Ingrese su nombre de usuario");
        userTxt.setBorder(null);
        userTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        bg.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 410, 30));

        eyeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ojo.png"))); // NOI18N
        eyeBtn.setText("jLabel2");
        eyeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyeBtnMouseClicked(evt);
            }
        });
        bg.add(eyeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 30, 30));

        passTxt.setText("Ingrese su contraseña");
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        bg.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 410, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseEntered
        loginBtn.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_loginBtnTxtMouseEntered

    private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseExited
        loginBtn.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_loginBtnTxtMouseExited

    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseClicked
        ejecutarLogin();
    }//GEN-LAST:event_loginBtnTxtMouseClicked

    private void RegisLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisLabelMouseEntered
        RegisLabel.setForeground(Color.blue);
    }//GEN-LAST:event_RegisLabelMouseEntered

    private void RegisLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisLabelMouseExited
        RegisLabel.setForeground(Color.gray);
    }//GEN-LAST:event_RegisLabelMouseExited

    private void RegisLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisLabelMouseClicked
        new FrmRegister().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RegisLabelMouseClicked

    private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseClicked

        this.setVisible(false);
    }//GEN-LAST:event_loginBtnMouseClicked

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMousePressed
        ValidarCamposLlenos(userTxt, passTxt, "Ingrese su nombre de usuario", "Ingrese su contraseña");
    }//GEN-LAST:event_userTxtMousePressed

    private void eyeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeBtnMouseClicked
        String passTexto = String.valueOf(passTxt.getPassword());

        // Evitar activar el ojo si aún tiene el mensaje de placeholder
        if (passTexto.equals("Ingrese su contraseña") || passTexto.isEmpty()) {
            return;
        }

        if (passVisible) {
            // Ocultar la contraseña
            passTxt.setEchoChar('*');
            eyeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ojo.png")));
            passVisible = false;
        } else {
            // Mostrar la contraseña
            passTxt.setEchoChar((char) 0);
            eyeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ojo b.png")));
            passVisible = true;
        }
    }//GEN-LAST:event_eyeBtnMouseClicked

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed
        ValidarCamposLlenos(passTxt, userTxt, "Ingrese su contraseña", "Ingrese su nombre de usuario");
        // Enmascarar
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setEchoChar('*');
        }
    }//GEN-LAST:event_passTxtMousePressed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RegisLabel;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel citybg;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JLabel eyeBtn;
    private javax.swing.JLabel favicon;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginBtnTxt;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logoname;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    public static void ValidarCamposLlenos(JTextField campo1, JTextField campo2, String mensaje1, String mensaje2) {
        // Al entrar al campo activo (campo1)
        if (campo1.getText().equals(mensaje1)) {
            campo1.setText("");
            campo1.setForeground(Color.black);

            // Si es un campo de contraseña, activa las viñetas/asteriscos al escribir
            if (campo1 instanceof JPasswordField) {
                ((JPasswordField) campo1).setEchoChar('*');
            }
        }

        // Al salir del otro campo (campo2), si quedó vacío, restaura el placeholder
        if (campo2.getText().isEmpty()) {
            campo2.setText(mensaje2);
            campo2.setForeground(new Color(153, 153, 153));

            // Si es un campo de contraseña, quita las viñetas para que el placeholder sea legible
            if (campo2 instanceof JPasswordField) {
                ((JPasswordField) campo2).setEchoChar((char) 0);
            }
        }
    }

    private void ejecutarLogin() {
        String usuarioIngresado = userTxt.getText().trim();
        String passwordIngresada = new String(passTxt.getPassword()).trim();

        // Validar campos obligatorios utilizando los helpers
        if (esInvalido(usuarioIngresado, "Ingrese su nombre de usuario")) {
            mostrarAdvertencia("Por favor, ingrese su nombre de usuario o correo.", userTxt);
            return;
        }

        if (esInvalido(passwordIngresada, "Ingrese su contraseña")) {
            mostrarAdvertencia("Por favor, ingrese su contraseña.", passTxt);
            return;
        }

        // Validar longitud mínima de contraseña
        if (passwordIngresada.length() < 3) {
            mostrarAdvertencia("La contraseña ingresada es demasiado corta.", passTxt);
            return;
        }

        // Intentar autenticación en la BD vía UserDAO
        try {
            User usuario = userDAO.autenticarUsuario(usuarioIngresado, passwordIngresada);

            if (usuario != null) {
                JOptionPane.showMessageDialog(this,
                        "¡Bienvenido/a de nuevo, " + usuario.getNombre() + "!",
                        "Acceso Concedido",
                        JOptionPane.INFORMATION_MESSAGE);

                new FrmDashboard(usuario).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Usuario o contraseña incorrectos.",
                        "Error de Autenticación",
                        JOptionPane.ERROR_MESSAGE);

                passTxt.setText("");
                passTxt.setForeground(Color.black);
                passTxt.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al conectar con la base de datos:\n" + e.getMessage(),
                    "Error de Conexión",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

//Métodos para evitar código repetido
// Comprueba si el texto está vacío o contiene el placeholder
    private boolean esInvalido(String texto, String placeholder) {
        return texto.isEmpty() || texto.equals(placeholder);
    }

// Muestra la ventana flotante de advertencia y asigna el foco al campo correspondiente
    private void mostrarAdvertencia(String mensaje, javax.swing.JComponent campo) {
        JOptionPane.showMessageDialog(this, mensaje, "Campo Requerido", JOptionPane.WARNING_MESSAGE);
        campo.requestFocus();
    }
}
