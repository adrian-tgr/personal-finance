package com.finanzas.personalFinance.Entity;

import jakarta.persistence.*; //Java Persistence API 7 Codigo a tablas y columnas en Postgre
import java.time.LocalDateTime; //Manejar fechas y horas sin zona horaria

@Entity //Indica a Spring Boot que es una entidad de Postgre y se convertira en tabla
@Table(name = "usuarios") //Nombre de la tabla en Postgre
public class User {

    //Atributos
    @Id//Marca a id como la Clave primaria de la tabla, es decir es el identificador unico por usuario
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Postgre le asigna un numero identificador a cada usuario
    private Long id;

    @Column(nullable = false, length = 100)//Column indica las reglas del nombre, no puede ser vacio ni tampoco puede ser mayor a 100 caractrs
    private String nombre;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "fecha_creacion", updatable = false) //Utilizo snake_case para que este valor se trabaje bien en la bd
    private LocalDateTime fechaCreacion;

    public User() { //Requisito obligatorio de JPA/Hibernate (constructor vacio) para cuando cree el objeto vacio
    }

    public User(Long id, String nombre, String email, String password, LocalDateTime fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
    @PrePersist //para ejecutar el metodo a la hora de insertar la fecha de creacion en la bd
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now(); //Toma la fecha y hora del computador y la almacena dentro del atributo
    }
}
