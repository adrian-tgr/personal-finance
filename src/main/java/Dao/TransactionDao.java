package Dao;

import java.sql.*; //Connection, PreparedStatement, ResultSet, SQLException
import DataBase.ConexionBD;
import com.raven.model.ModelTransaction;

public class TransactionDao {

    public boolean agregar(ModelTransaction t) {
        // Consulta SQL para insertar el registro y retornar el ID generado por PostgreSQL
        String sql = "INSERT INTO transactions (description, category, date, type, amount) VALUES (?, ?, ?, ?, ?) RETURNING id";

        try (Connection conn = ConexionBD.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Asignación de parámetros a los comodines (?) de la SQL
            stmt.setString(1, t.getDescription());
            stmt.setString(2, t.getCategory());
            stmt.setString(3, t.getDate());
            stmt.setString(4, t.getType());
            stmt.setDouble(5, t.getAmount());

            // Ejecutar la consulta y guardar el id devuelto por SQL
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Asignar el id recién generado al objeto ModelTransaction
                t.setId(rs.getLong("id"));
                return true;
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar transacción en PostgreSQL: " + e.getMessage());
        }
        return false;
    }

    //eliminar una transacción
    public boolean eliminar(long id) {
        String sql = "DELETE FROM transactions WHERE id = ?";

        try (Connection conn = ConexionBD.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            // Retorna true si afectó al menos a 1 fila en la base de datos
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar transacción en PostgreSQL: " + e.getMessage());
            return false;
        }
    }

    public java.util.List<ModelTransaction> listar() {
        java.util.List<ModelTransaction> lista = new java.util.ArrayList<>();
        String sql = "SELECT id, description, category, date, type, amount FROM transactions ORDER BY id ASC";

        try (Connection conn = DataBase.ConexionBD.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String tipo = rs.getString("type");

                // Asignar icono dinámico según el tipo de movimiento
                String iconPath = tipo.equalsIgnoreCase("Ingreso") ? "/Images/plus.png" : "/Images/less.png";
                javax.swing.ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource(iconPath));

                // Se instancia usando el constructor con ID
                ModelTransaction t = new ModelTransaction(
                        icon,
                        rs.getString("description"),
                        rs.getString("category"),
                        rs.getString("date"),
                        tipo,
                        rs.getDouble("amount"),
                        rs.getLong("id")
                );
                lista.add(t);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar transacciones en BD: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizar(ModelTransaction t) {
        String sql = "UPDATE transactions SET description = ?, category = ?, date = ?, type = ?, amount = ? WHERE id = ?";

        try (Connection conn = ConexionBD.getConexion(); // Usa el mismo método de conexión que ya tienes en TransactionDao
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, t.getDescription());
            stmt.setString(2, t.getCategory());
            stmt.setString(3, t.getDate());
            stmt.setString(4, t.getType());
            stmt.setDouble(5, t.getAmount());
            stmt.setLong(6, t.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar transacción en BD: " + e.getMessage());
            return false;
        }
    }
}
