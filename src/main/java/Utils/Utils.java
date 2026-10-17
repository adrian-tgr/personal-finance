package Utils;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Utils {

    public static void configurarPlaceholder(JTextField campo, String placeholder) {
        campo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                // Al entrar al campo: limpia el placeholder y cambia el texto a negro
                if (campo.getText().equals(placeholder)) {
                    campo.setText("");
                    campo.setForeground(Color.BLACK);
                    if (campo instanceof JPasswordField) { //Si detecta que el campo es un JPasswordfield...
                        ((JPasswordField) campo).setEchoChar('*');
                    }
                }
            }

            @Override
            public void focusLost(FocusEvent evt) {
                // Al salir del campo: si quedó vacío, restaura el placeholder en gris
                if (campo.getText().trim().isEmpty()) {
                    campo.setText(placeholder);
                    campo.setForeground(new Color(153, 153, 153));
                    if (campo instanceof JPasswordField) {
                        ((JPasswordField) campo).setEchoChar((char) 0);
                    }
                }
            }
        });
    }

    public static void ValidarEspacios(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') { //Si el programa detecta un espacio
                    e.consume(); //Lo bloquea
                }
            }

        });
    }
}
