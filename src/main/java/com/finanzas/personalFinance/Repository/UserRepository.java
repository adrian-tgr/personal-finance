package com.finanzas.personalFinance.Repository;

import com.finanzas.personalFinance.Entity.User; //Llama a la endiad usuario
import org.springframework.data.jpa.repository.JpaRepository; //Herramientas de Spring data JPA
import org.springframework.stereotype.Repository;

@Repository //Marcador de Componente de Base de Datos / distintivo de Spring para acceso a datos
public interface UserRepository extends JpaRepository<User, Long> { //Conector CRUD (Crear, Leer, Actualizar, Borrar) para la tabla usuarios
    
    // Metodo para saber si un correo ya existe
    boolean existsByEmail(String email);
}