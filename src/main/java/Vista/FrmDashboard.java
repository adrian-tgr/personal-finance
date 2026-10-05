package Vista;

// Modelo del usuario autenticado
import Model.User;

// Componentes Swing
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;

public class FrmDashboard extends javax.swing.JFrame {

    // Usuario que inició sesión
    private User usuarioActual;

    // Constructor que recibe al usuario
    public FrmDashboard(User usuario) {
        this.usuarioActual = usuario;
        
        // Personalización de bienvenida
        setTitle("Panel Principal - Finanzas Personales");
        setLocationRelativeTo(null);
        mostrarBienvenida();
    }

    private void mostrarBienvenida() {
        if (usuarioActual != null) {
            System.out.println("Sesión iniciada por: " + usuarioActual.getNombre());
            // Si tienes un JLabel en el diseño llamado lblBienvenida:
            // lblBienvenida.setText("Bienvenido, " + usuarioActual.getNombre());
        }
    }
}