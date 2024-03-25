package com.mycompany.combobox.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Provincias {

    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public Vector<Provincias> monstrarEstados() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Provincias> datos = new Vector<>();
        Provincias dat = null;

        try {
            String sql = "SELECT * FROM provincias";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Provincias();
            dat.setId(0);
            dat.setNombre("Selecciona provincia");
            datos.add(dat);

            while (rs.next()) {
                dat = new Provincias();
                dat.setId(rs.getInt("id_provincia"));
                dat.setNombre(rs.getString("provincia"));
                datos.add(dat);
            }

            rs.close();
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return datos;
    }

}
