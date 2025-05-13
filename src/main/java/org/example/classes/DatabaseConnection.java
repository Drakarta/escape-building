package org.example.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DatabaseConnection {

    private static final String DB_PATH = "database/test.db";

    // Reusable method to get DB connection
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + DB_PATH;
        return DriverManager.getConnection(url);
    }

    // Method to search for all rows in a given table
    public static void searchFor(String tableName) {
        String query = "SELECT * FROM " + tableName;

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            System.out.println("Results from table: " + tableName);
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(meta.getColumnName(i) + ": " + rs.getString(i) + "  ");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
    }
}

