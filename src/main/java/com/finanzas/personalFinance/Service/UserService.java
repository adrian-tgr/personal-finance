package com.finanzas.personalFinance.Service;
import com.finanzas.personalFinance.Entity.User;
import com.finanzas.personalFinance.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) { 
        // Validar que el correo no exista
        if (userRepository.existsByEmail(user.getEmail())) { //Verificación de gmail ya existente
            throw new IllegalArgumentException("Error: El correo ingresado ya está en uso.");
        }

        // Guardar en PostgreSQL
        return userRepository.save(user);
    }
}