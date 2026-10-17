package Dao;

import Model.Transaction;
import java.sql.*; //Connection, PreparedStatement, ResultSet, SQLException
import DataBase.ConexionBD;

public class TransactionDao {
    // Método para insertar una nueva transacción en PostgreSQL
    public boolean agregar(Transaction t) {
        //consulta SQL para insertar un nuevo registro en la tabla transactions
        String sql = "INSERT INTO transactions (amount, description, date, type, category_id, user_id) VALUES (?, ?, ?, ?, ?, ?) RETURNING id"; 
        // ? se remplazan por los datos reales y retorna el id

        try (Connection conn = ConexionBD.obtenerConexion();//Llama a conexion para abrir el canal con SQL
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, t.getMonto());//Reemplaza 1er "?" con el valor del monto
            stmt.setString(2, t.getDescripcion()); //Reemplaza el segundo "?"" con la descripcion
            stmt.setTimestamp(3, new java.sql.Timestamp(t.getDate().getTime()));//Le envia la fecha de la transaccion a postgre
            stmt.setString(4, t.getType().name());//Reemplaza con el tipo de transaccion
            stmt.setLong(5, t.getCategory().getId());//ID numérico de la categoría a la que pertenece la transacción
            stmt.setLong(6, t.getUser().getId()); //ID del usuario

            //obtener el ID generado en la BD
            ResultSet rs = stmt.executeQuery(); //Guardar consulta de la base de datos
            if (rs.next()) {//Comprueba si postgre envio el id
                t.setId(rs.getLong("id")); // Asigna el ID retornado al objeto
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar transacción: " + e.getMessage());
        }
        return false;
    }

    //eliminar una transacción
    public boolean eliminar(Long id) {
        String sql = "DELETE FROM transactions WHERE id = ?";
        //Abrir conexion
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            //Si afecta almenos 1 fila significa que elimino la transaccion
            return stmt.executeUpdate() > 0; 

        } catch (SQLException e) {
            System.err.println("Error al eliminar transacción: " + e.getMessage());
            return false;
        }
    }
}