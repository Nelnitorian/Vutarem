package com.vutarem.db;

import java.sql.SQLException;

import com.vutarem.common.Votante;

import java.util.List;

public interface IVotanteDAO {

    public void crea(Votante persona) throws SQLException;

    public void borra(String dni) throws SQLException;

    public void actualiza(String dni, boolean ha_votado) throws SQLException;

    public Votante lee(String dni) throws SQLException;

    public List<Votante> leeTodos() throws SQLException;
}