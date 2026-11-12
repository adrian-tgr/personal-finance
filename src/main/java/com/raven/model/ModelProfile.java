package com.raven.model;

//dibujar una imagen y un texto juntos dentro de la misma celda de la tabla.
import javax.swing.Icon;

public class ModelProfile {

    private Icon icon;
    private String name;

    public ModelProfile(Icon icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public ModelProfile() {
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }

}
