package Dao;

// Conexión a BD
import DataBase.ConexionBD;
// Enum y Modelos
import Enums.TransactionType;
import Model.Category;
import Model.User;

// Clases SQL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// Estructuras de datos
import java.util.ArrayList;
import java.util.List;

// Operaciones de base de datos para categorías
public class CategoryDAO {

    // Guarda una nueva categoría en la BD
    public boolean registrarCategoria(Category categoria) {
        
        // Query SQL de inserción
        String sql = "INSERT INTO categorias (name, type, user_id) VALUES (?, ?, ?)";
        
        // Conexión y preparación
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // Asignación de datos
            ps.setString(1, categoria.getName());
            ps.setString(2, categoria.getType().name()); // Guardamos el Enum como texto
            ps.setLong(3, categoria.getUser().getId());
            
            // Ejecución
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al registrar categoría: " + e.getMessage());
            return false;
        }
    }

    // Obtiene la lista de categorías de un usuario específico
    public List<Category> obtenerCategoriasPorUsuario(Long userId) {
        
        // Lista dinámica (Vector) para guardar resultados
        List<Category> listaCategorias = new ArrayList<>();
        
        // Query SQL de búsqueda
        String sql = "SELECT * FROM categorias WHERE user_id = ?";
        
        // Conexión y preparación
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // Filtro por ID de usuario
            ps.setLong(1, userId);
            
            // Ejecución y lectura
            try (ResultSet rs = ps.executeQuery()) {
                
                // Bucle para recorrer todas las filas encontradas
                while (rs.next()) {
                    
                    // Creación de usuario temporal (solo con ID)
                    User usuarioTemp = new User();
                    usuarioTemp.setId(rs.getLong("user_id"));
                    
                    // Reconstrucción del objeto Category
                    Category categoria = new Category(
                        rs.getLong("id"),
                        rs.getString("name"),
                        TransactionType.valueOf(rs.getString("type")), // Convierte texto a Enum
                        usuarioTemp
                    );
                    
                    // Se añade a la lista
                    listaCategorias.add(categoria);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener categorías: " + e.getMessage());
        }
        
        // Retorna la lista llena o vacía
        return listaCategorias;
    }
}