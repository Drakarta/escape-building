package org.example.utils;

import java.sql.*;
import java.util.*;
public class DatabaseConnection {

    private static final String DB_PATH = "database/test.db";

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:database/test.db" + DB_PATH;
        return DriverManager.getConnection(url);
    }

    public static Object execute(String sql, List<Object> parameters) {
        // Voorbeeld van een SELECT-query:
        // DatabaseConnection.execute("SELECT * FROM Room WHERE name = ?", List.of("Room1"));
        
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Zet parameters (voorkomt SQL-injectie)
            for (int i = 0; i < parameters.size(); i++) {
                stmt.setObject(i + 1, parameters.get(i));
            }
            // Checkt of de query een SELECT-query is
            if (sql.trim().toUpperCase().startsWith("SELECT")) {
                try (ResultSet rs = stmt.executeQuery()) {
                    List<Map<String, String>> result = new ArrayList<>();
                    ResultSetMetaData meta = rs.getMetaData();
                    int columnCount = meta.getColumnCount();

                    while (rs.next()) {
                        Map<String, String> row = new HashMap<>();
                        for (int i = 1; i <= columnCount; i++) {
                            row.put(meta.getColumnName(i), rs.getString(i));
                        }
                        result.add(row);
                    }

                    return result;
                }
            } else {
                // Voor INSERT, UPDATE, DELETE: geef aantal gewijzigde rijen terug
                return stmt.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return null;
        }
    }

    public static Object execute(String sql) {
        // DatabaseConnection.execute("SELECT * FROM Room WHERE name = "Room1");
        // zonder sql parameters
        return execute(sql, List.of());
    }
}
