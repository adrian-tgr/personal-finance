package Model;

import java.util.Date; //Manejar Fechas

public class User {

    //Atributos
    private Long id;

    private String nombre;

    private String email;

    private String password;

    private Date fechaCreacion;

    public User() { //Constructor vacio por defecto
    }
    
    //Constructor sin ID para crear un nuevo usuario antes de insertarlo en la BD
    public User (String nombre, String email, String password, Date fechaCreacion) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.fechaCreacion = fechaCreacion;
    }
    
    //Constructor completo con ID para instanciar usuarios leídos desde PostgreSQL
    public User(Long id, String nombre, String email, String password, Date fechaCreacion) {
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
}
