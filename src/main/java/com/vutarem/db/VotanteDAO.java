package com.vutarem.db;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vutarem.common.Votante;
import com.vutarem.common.FabricaDni;

import java.util.List;
import java.util.ArrayList;

public class VotanteDAO implements IVotanteDAO{
    private static final String TABLE = "votantes";

    public VotanteDAO(){
    }

    public void crea(Votante persona) throws SQLException{
        String QUERY_CREA = "INSERT INTO "+TABLE+" (dni, nombre, ha_votado, contrasenia) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_CREA);

        st.setString(1, persona.getDni().toString());
        st.setString(2, persona.getNombre());
        st.setBoolean(3, persona.isHa_votado());
        st.setString(4, persona.getContrasenia());
        
        st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }
        
    }

    public void borra(String dni) throws SQLException{
        final String QUERY_BORRA = "DELETE FROM "+TABLE+" WHERE dni=?";

        Connection conn = null;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_BORRA);
        st.setString(1, dni);

        st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }

        return;

    }

    // public void borraTodos() throws SQLException{
    //     final String QUERY_BORRA_TODOS = "DELETE FROM "+TABLE;

    //     Connection conn = null;
    //     PreparedStatement st = null;

    //     conn = Conexion.conecta();
    //     st = conn.prepareStatement(QUERY_BORRA_TODOS);

    //     st.executeUpdate();

    //     try {
    //         conn.close();
    //         st.close();
    //     } catch (Exception e){
    //         // Ignore
    //     }

    //     return;

    // }

    public void actualiza(String dni, boolean ha_votado) throws SQLException{
        final String QUERY_ACTUALIZA = "UPDATE "+TABLE+" SET ha_votado = ? WHERE dni = ?";

        Connection conn = null;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_ACTUALIZA);
        st.setBoolean(1, ha_votado);
        st.setString(2, dni);

        st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }

        return;

        
    }

    public Votante lee(String dni) throws SQLException{
        final String QUERY_LEE = "SELECT * FROM "+TABLE+" WHERE dni = ? ";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;

        Votante vot = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_LEE);
        st.setString(1, dni);

        rs = st.executeQuery();

        while (rs.next()) {
            vot = new Votante(FabricaDni.creaDni(rs.getString(1)), rs.getString(2), rs.getBoolean(3), rs.getString(4));
            break;
        }

        try {
            conn.close();
            st.close();
            rs.close();
        } catch (Exception e){
            // Ignore
        }

        return vot;
    }

    public List<Votante> leeTodos() throws SQLException{
        final String QUERY_LEE_TODOS = "SELECT * FROM "+TABLE;

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;

        Votante vot = null;
        ArrayList<Votante> lst = new ArrayList<Votante>();

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_LEE_TODOS);

        rs = st.executeQuery();

        while (rs.next()) {
            vot = new Votante(FabricaDni.creaDni(rs.getString(1)), rs.getString(2), rs.getBoolean(3), rs.getString(4));
            lst.add(vot);
        }

        try {
            conn.close();
            st.close();
            rs.close();
        } catch (Exception e){
            // Ignore
        }

        return lst;
    }
}