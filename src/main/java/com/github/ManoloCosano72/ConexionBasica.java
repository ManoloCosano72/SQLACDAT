package com.github.ManoloCosano72;

import java.sql.*;

public class ConexionBasica {
    private static final String URL = "jdbc:mysql://localhost:3306/desguace";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexion exitosa");
            Statement st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}