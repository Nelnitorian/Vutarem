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

    // public void crea(Votante persona) throws SQLException{
    //     String QUERY_CREA = "SELECT * FROM "+TABLE+" WHERE apellidos = ? ";

    //     Connection conn = null;
    //     ResultSet rs = null;
    //     PreparedStatement st = null;

    //     conn = Conexion.conecta();
    //     st = conn.prepareStatement(QUERY_CREA);
    //     st.setString(1, apellidos);

    //     rs = st.executeQuery();

    //     try {
    //         conn.close();
    //         st.close();
    //         rs.close();
    //     } catch (Exception e){
    //         // Ignore
    //     }
        
    // }

    public void borra(String dni) throws SQLException{
        final String QUERY_BORRA = "SELECT * FROM "+TABLE+" WHERE apellidos = ? ";

    }

    public void borraTodos() throws SQLException{

    }

    public void actualiza(String dni, boolean haVotado) throws SQLException{
        final String QUERY_ACTUALIZA = "SELECT * FROM "+TABLE+" WHERE apellidos = ? ";
        
    }

    public Votante lee(String dni) throws SQLException{
        final String QUERY_LEE = "SELECT * FROM "+TABLE+" WHERE apellidos = ? ";

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

    public List<Votante> leeTodos() throws SQLException{
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