package com.vutarem.db;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vutarem.common.Candidato;

import java.util.List;
import java.util.ArrayList;

public class CandidatoDAO implements ICandidatoDAO{
    private static final String TABLE = "candidatos";

    public CandidatoDAO(){
    }

    public void crea(Candidato cand) throws SQLException{
        String QUERY_CREA = "INSERT INTO "+TABLE+" (nombre, partido, votos) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_CREA);

        st.setString(1, cand.getNombre());
        st.setString(2, cand.getPartido());
        st.setInt(3, 0);
        
        st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }
        
    }

    public void borra(int id) throws SQLException{
        final String QUERY_BORRA = "DELETE FROM "+TABLE+" WHERE id=?";

        Connection conn = null;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_BORRA);
        st.setInt(1, id);

        st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }

        return;

    }

    public void vota(int id) throws SQLException{
        final String QUERY_ACTUALIZA = "UPDATE "+TABLE+" SET votos = votos + 1 WHERE id = ?";

        Connection conn = null;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_ACTUALIZA);
        st.setInt(1, id);

        st.executeUpdate();

        try {
            conn.close();
            st.close();
        } catch (Exception e){
            // Ignore
        }

        return;        
    }

    public Candidato lee(int id) throws SQLException{
        final String QUERY_LEE = "SELECT * FROM "+TABLE+" WHERE id = ? ";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;

        Candidato cand = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_LEE);
        st.setInt(1, id);

        rs = st.executeQuery();

        while (rs.next()) {
            cand = new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            break;
        }

        try {
            conn.close();
            st.close();
            rs.close();
        } catch (Exception e){
            // Ignore
        }

        return cand;
    }

    public List<Candidato> leeTodos() throws SQLException{
        final String QUERY_LEE_TODOS = "SELECT * FROM "+TABLE;

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;

        Candidato cand = null;
        ArrayList<Candidato> lst = new ArrayList<Candidato>();

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_LEE_TODOS);

        rs = st.executeQuery();

        while (rs.next()) {
            cand = new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            lst.add(cand);
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