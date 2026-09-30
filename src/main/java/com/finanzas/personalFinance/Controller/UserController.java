
package com.finanzas.personalFinance.Controller;

//Entidad de usuario y servicio con la lógica de negocio
import com.finanzas.personalFinance.Entity.User;
import com.finanzas.personalFinance.Service.UserService;

//Manejo de respuestas y estados de protocolo HTTP (201 Created, 400 Bad Request)
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//Anotaciones de Spring MVC para construir la API REST
import org.springframework.web.bind.annotation.*;

//Define esta clase como un controlador REST que retornará respuestas en JSON
@RestController

//Define la URL base '/api/users' para acceder a este controlador
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    //Inyección de dependencias para conectar el controlador con la capa de servicio
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Escucha peticiones HTTP POST para guardar un nuevo usuario
    @PostMapping
    public ResponseEntity<?> registerUser(
            //Convierte el objeto JSON entrante del cliente a un objeto Java 'User'
            @RequestBody User user
    ) {
        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}