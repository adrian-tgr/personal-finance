package com.finanzas.personalFinance.Entity;

import jakarta.persistence.*; //Java Persistence API 7Codigo a tablas y columnas en Postgre
import lombok.*; //Reducir codigo repetitivo (getters,setters,constructores
import java.time.LocalDateTime; //Manejar fechas y horas sin zona horaria

@Entity //Indica a Spring Boot que es una entidad de Postgre y se convertira en tabla
@Table(name = "usuarios") //Nombre de la tabla en Postgre
@Getter //Getter y setter en segundo plano
@Setter
@NoArgsConstructor //Constructor sin parametros para instanciar objetos en JPA
@AllArgsConstructor //Constructor con todos los atributos de la clase
@Builder //Facilitar consstruccion de objetos
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
    
    @PrePersist //para ejecutar el metodo a la hora de insertar la fecha de creacion en la bd
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now(); //Toma la fecha y hora del computador y la almacena dentro del atributo
    }
}
