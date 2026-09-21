package com.finanzas.personalFinance.Repository;

import com.finanzas.personalFinance.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Metodo para saber si un correo ya existe
    boolean existsByEmail(String email);
}