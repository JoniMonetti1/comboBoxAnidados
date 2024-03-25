package com.mycompany.combobox.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String user = "root";
    private String base = "argentina";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;

    public Connection getConexion() {
        try {
            con = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return con;
    }
}
