package com.vutarem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexion {

    static private String TABLE = "contactos";
    static private String DATABASE = "nelio";
    static private String query = "SELECT * FROM "+table+" WHERE apellidos = ? ";

    public Conexion(){
        conn = null;
    }

    static public Connection conecta() throws SQLException{
        Connection conn = this.connect(DATABASE, "nelio", "test1234");
        return conn;
    }
    
    static private Connection connect(String database, String user, String password) throws SQLException{
        Connection conn = null;
        String url = "jdbc:postgresql://localhost:5432/" + database;

        conn = DriverManager.getConnection(url, user, password);
        // System.  out.println("Connected to the PostgreSQL server successfully.");

        return conn;
    }



        Contacto contacto = null;

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        try{

            conn = this.connect(database, "nelio", "test1234");

            st = conn.prepareStatement(query);
            st.setString(1, apellidos);

            rs = st.executeQuery();
            while (rs.next()) {
                contacto = new Contacto(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                conn.close();

                st.close();
                rs.close();
            } catch (Exception e){

            }
        }

        return contacto;
    }
    
    private Connection connect(String database, String user, String password) throws SQLException{
        Connection conn = null;
        String url = "jdbc:postgresql://localhost:5432/" + database;

        conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to the PostgreSQL server successfully.");

        return conn;
    }
}