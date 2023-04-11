package com.vutarem.db;

import java.sql.SQLException;

import com.vutarem.common.Candidato;

import java.util.List;

public interface ICandidatoDAO {

    public void crea(Candidato cand) throws SQLException;

    public void borra(int id) throws SQLException;

    public void vota(int id) throws SQLException;

    public Candidato lee(int id) throws SQLException;

    public List<Candidato> leeTodos() throws SQLException;

    public int leeId(String nombre, String partido) throws SQLException;
}