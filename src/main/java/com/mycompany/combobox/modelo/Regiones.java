package com.mycompany.combobox.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Regiones {

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

    public Vector<Regiones> monstrarRegiones(Integer idProvincia) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Regiones> datos = new Vector<>();
        Regiones dat = null;

        try {
            String sql = "SELECT * FROM regiones WHERE id_provincia=" + idProvincia;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Regiones();
            dat.setId(0);
            dat.setNombre("Selecciona region");
            datos.add(dat);

            while (rs.next()) {
                dat = new Regiones();
                dat.setId(rs.getInt("id_region"));
                dat.setNombre(rs.getString("region"));
                datos.add(dat);
            }

            rs.close();
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return datos;
    }

}
