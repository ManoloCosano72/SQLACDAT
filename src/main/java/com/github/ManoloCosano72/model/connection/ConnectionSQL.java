package com.github.ManoloCosano72.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    private static Connection conn = null;
    private static final String URL = "jdbc:mysql://localhost:3306/desguace";
    private static final String USER = "root";
    private static final String PASS = "";

    public ConnectionSQL() {

    }
    public static Connection getConnection(){
        if (conn==null){
            try{
                conn = DriverManager.getConnection(URL,USER,PASS);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return conn;
    }
    public static void closeConneciton(){
        if(conn!=null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
