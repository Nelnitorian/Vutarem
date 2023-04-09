package com.vutarem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vutarem.common.Candidato;
import com.vutarem.db.Conexion;

import java.util.List;

public class VotanteDAO {
    static private Connection conn = Conexion.conecta();

    static private String TABLE = "contactos";
    static private String DATABASE = "nelio";
    static private String QUERY_BORRA = "SELECT * FROM "+table+" WHERE apellidos = ? ";
    static private String QUERY_ACTUALIZA = "SELECT * FROM "+table+" WHERE apellidos = ? ";
    static private String QUERY_LEE = "SELECT * FROM "+table+" WHERE apellidos = ? ";

    public VotanteDAO(){
    }

    public void crea(Votante persona) throws SQLException{
        String QUERY_CREA = "SELECT * FROM "+table+" WHERE apellidos = ? ";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;

        conn = Conexion.conecta();
        st = conn.prepareStatement(QUERY_CREA);
        st.setString(1, apellidos);

        rs = st.executeQuery();

        try {
            conn.close();
            st.close();
            rs.close();
        } catch (Exception e){
            // Ignore
        }
        
    }

    public void crea(List<Votante> lista) throws SQLException{
        
    }

    public void borra(String dni) throws SQLException{

    }

    public void borraTodos() throws SQLException{

    }

    public void actualiza(String dni, boolean haVotado) throws SQLException{
        
    }

    public Votante lee(String dni) throws SQLException{

    }    
}