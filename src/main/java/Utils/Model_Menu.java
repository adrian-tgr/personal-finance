package Utils;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Menu {

    String icono;
    String nombre;
    TipoMenu tipo;

    public Model_Menu(String icono, String nombre, TipoMenu tipo) {
        this.icono = icono;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoMenu getTipo() {
        return tipo;
    }

    public void setTipo(TipoMenu tipo) {
        this.tipo = tipo;
    }

    public static enum TipoMenu {
        TITULO, MENU, EMPTY
    }

    public ImageIcon toIcon() {
        URL location = getClass().getResource("/Images/" + icono);

        if (location == null) {
            System.err.println("Imagen no encontrada: /Imagenes/" + icono);
            return new ImageIcon();
        }

        return new ImageIcon(location);
    }
}
