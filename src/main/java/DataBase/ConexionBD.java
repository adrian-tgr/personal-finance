package DataBase;

import java.sql.Connection;
import java.sql.DriverManager; //Buscar driver y conectar con SQL
import java.sql.SQLException; //Manejar errores, evitar que el programa se cierre

public class ConexionBD {

    // URL de conexión: protocolo, servidor, puerto y nombre de DB
    private static final String URL = "jdbc:postgresql://localhost:5432/finanzas_db";

    private static final String USER = "postgres";
     
    private static final String PASSWORD = "134611"; 

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}