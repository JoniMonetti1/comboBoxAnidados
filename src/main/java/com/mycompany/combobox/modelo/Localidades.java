package com.mycompany.combobox.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Localidades {

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

    public Vector<Localidades> monstrarLocalidades(Integer idRegion) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Localidades> datos = new Vector<>();
        Localidades dat = null;

        try {
            String sql = "SELECT * FROM t_localidad WHERE id_region=" + idRegion;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Localidades();
            dat.setId(0);
            dat.setNombre("Selecciona localidad");
            datos.add(dat);

            while (rs.next()) {
                dat = new Localidades();
                dat.setId(rs.getInt("id_localidad"));
                dat.setNombre(rs.getString("localidad"));
                datos.add(dat);
            }

            rs.close();
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return datos;
    }

}
