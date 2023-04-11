package com.vutarem.db;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vutarem.common.Votante;
import com.vutarem.common.FabricaDni;

import java.util.List;
import java.util.ArrayList;

public class VotanteDAO {
    private static final String TABLE = "votantes";

    public VotanteDAO(){
    }

    public static void crea(Votante persona) throws SQLException{
        String QUERY_CREA = "INSERT INTO "+TABLE+" (dni, nombre, ha_votado) VALUES (?, ?, ?)";

        Connection conn = null;
        int rs = 0;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_CREA);
        st.setString(1, persona.getDni().toString());
        st.setString(2, persona.getNombre());
        st.setBoolean(3, persona.isHa_votado());
        rs = st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }
        
    }

    public static void borra(String dni) throws SQLException{
        final String QUERY_BORRA = "DELETE FROM "+TABLE+" WHERE dni=?";

        Connection conn = null;
        int rs = 0;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_BORRA);
        st.setString(1, dni);

        rs = st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }

        return;

    }

    public static void borraTodos() throws SQLException{
        final String QUERY_BORRA_TODOS = "DELETE FROM "+TABLE;

        Connection conn = null;
        int rs = 0;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_BORRA_TODOS);

        rs = st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }

        return;

    }

    public static void actualiza(String dni, boolean ha_votado) throws SQLException{
        final String QUERY_ACTUALIZA = "UPDATE "+TABLE+" SET ha_votado = ? WHERE dni = ?";

        Connection conn = null;
        int rs = 0;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_ACTUALIZA);
        st.setBoolean(1, ha_votado);
        st.setString(2, dni);

        rs = st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }

        return;

        
    }

    public static Votante lee(String dni) throws SQLException{
        final String QUERY_LEE = "SELECT * FROM "+TABLE+" WHERE dni = ? ";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;

        Votante votante = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_LEE);
        st.setString(1, dni);

        rs = st.executeQuery();

        while (rs.next()) {
            votante = new Votante(FabricaDni.creaDni(rs.getString(1)), rs.getString(2), rs.getBoolean(3));
            break;
        }

        try {
            conn.close();
            st.close();
            rs.close();
        } catch (Exception e){
            // Ignore
        }

        return votante;
    }

    public static List<Votante> leeTodos() throws SQLException{
        final String QUERY_LEE_TODOS = "SELECT * FROM "+TABLE;

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;

        Votante votante = null;
        ArrayList<Votante> lst = new ArrayList<Votante>();

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_LEE_TODOS);

        rs = st.executeQuery();

        while (rs.next()) {
            votante = new Votante(FabricaDni.creaDni(rs.getString(1)), rs.getString(2), rs.getBoolean(3));
            lst.add(votante);
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