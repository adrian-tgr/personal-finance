package Utils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Action extends JPanel {

    private JButton cmdEdit;
    private JButton cmdDelete;

    public Action() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 8, 2));
        setOpaque(true);

        // Asegúrate de que los nombres coincidan con tus archivos en la carpeta Images
        cmdEdit = crearBoton("/Images/edit.png");
        cmdDelete = crearBoton("/Images/delete.png");

        add(cmdEdit);
        add(cmdDelete);
    }

    private JButton crearBoton(String rutaIcono) {
        JButton btn = new JButton();
        btn.setIcon(new ImageIcon(getClass().getResource(rutaIcono)));
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    // Métodos para obtener los botones cuando los conectemos a la tabla
    public JButton getCmdEdit() {
        return cmdEdit;
    }

    public JButton getCmdDelete() {
        return cmdDelete;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.setColor(new Color(230, 230, 230));
        grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
}