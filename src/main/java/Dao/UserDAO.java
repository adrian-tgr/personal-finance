
package Dao;

import DataBase.ConexionBD;
// Llamar datos del usuario
import Model.User;

// conexión física a PostgreSQL
import java.sql.Connection;
// Compilación y envío de consultas SQL seguras
import java.sql.PreparedStatement;
// Lectura de los resultados (filas) de la consulta
import java.sql.ResultSet;
// Manejo de errores de base de datos
import java.sql.SQLException;

// Operaciones de base de datos para la tabla usuarios
public class UserDAO {

    // Guarda un nuevo usuario en la BD
    public boolean registrarUsuario(User usuario) {
        
        // Ordenes a SQL
        String sql = "INSERT INTO usuarios (nombre, email, password, fecha_creacion) VALUES (?, ?, ?, ?)"; // ? funcionan como espacios reservados
        
        // Conexión y preparación de la consulta
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // Asignación de datos
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getPassword());
            ps.setDate(4, new java.sql.Date(usuario.getFechaCreacion().getTime()));
            
            // Ejecución del guardado
            int filasAfectadas = ps.executeUpdate();
            
            // Retorna true si tuvo éxito
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            // Captura de error
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    // Verifica credenciales y devuelve el usuario si es correcto
    public User autenticarUsuario(String email, String password) {
        
        // Consulta SQL parametrizada
        String sql = "SELECT * FROM usuarios WHERE email = ? AND password = ?";
        
        // Objeto contenedor del resultado
        User usuarioEncontrado = null;
        
        // Apertura de conexión y preparación de consulta
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // Asignación de credenciales
            ps.setString(1, email);
            ps.setString(2, password);
            
            // Ejecución de la consulta y lectura del cursor (ResultSet)
            try (ResultSet rs = ps.executeQuery()) {
                
                // Si existe al menos un registro que coincida
                if (rs.next()) {
                    
                    // Reconstrucción del objeto User desde la BD
                    usuarioEncontrado = new User(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getDate("fecha_creacion")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al autenticar usuario: " + e.getMessage());
        }
        
        // Retorna el usuario o null si falla
        return usuarioEncontrado; 
    }
}
