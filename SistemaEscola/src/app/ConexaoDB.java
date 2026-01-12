package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConexaoDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/escola_at";
    private static final String USER = "postgres";
    private static final String PASSWORD = "SUA_SENHA_AQUI";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}