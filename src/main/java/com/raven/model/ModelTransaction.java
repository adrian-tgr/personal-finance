package com.raven.model;

//REPRESENTAR CADA MOVIMIENTO FINANCIERO
import javax.swing.Icon;

public class ModelTransaction {

    private Icon icon;
    private String description;
    private String category;
    private String date;
    private String type; // Ingreso o Gasto
    private double amount;
    private long id;

    public ModelTransaction() {
    }

    public ModelTransaction(Icon icon, String description, String category, String date, String type, double amount) {
        this.icon = icon;
        this.description = description;
        this.category = category;
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    public ModelTransaction(Icon icon, String description, String category, String date, String type, double amount, long id) {
        this.icon = icon;
        this.description = description;
        this.category = category;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Object[] toRowTable() {
        return new Object[]{ // Se transforma en un arreglo de objetos
            description,
            date,
            amount,
            type
        };
    }
}
