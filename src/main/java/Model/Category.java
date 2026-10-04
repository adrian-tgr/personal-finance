package Model;

import Enums.TransactionType;

// Representa una categoría financiera en memoria
public class Category {

    // ID único en la BD
    private Long id;

    // Nombre de la categoría
    private String name;

    // Tipo (INCOME o EXPENSE)
    private TransactionType type;

    // Usuario propietario
    private User user;

    // Constructor vacío
    public Category() {
    }

    // Constructor para nuevas categorías
    public Category(String name, TransactionType type, User user) {
        this.name = name;
        this.type = type;
        this.user = user;
    }

    // Constructor completo para BD
    public Category(Long id, String name, TransactionType type, User user) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.user = user;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}