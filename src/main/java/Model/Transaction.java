package Model;

import Enums.TransactionType;
import java.util.Date;

public class Transaction {

    private Long id;
    private Double monto;
    private String descripcion;
    private Date date;
    private TransactionType type; // Income o Expense
    private Category category; // Para manejar la categoria de la transaccion
    private User user; // Usuario dueño del registro

    //Sin id para transacciones antes de guardar en DB
    public Transaction(Double monto, String descripcion, Date date, TransactionType type, Category category,
            User user) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.date = date;
        this.type = type;
        this.category = category;
        this.user = user;
    }

    // Constructor completo con ID (Para transacciones leídas desde la BD)
    public Transaction(Double monto, String descripcion, Date date, TransactionType type, Category category,
            User user, Long id) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.date = date;
        this.type = type;
        this.category = category;
        this.user = user;
        this.id = id;
    }

    // Gttrs y Sttrs
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
