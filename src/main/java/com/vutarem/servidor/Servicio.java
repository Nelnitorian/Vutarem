package com.vutarem.servidor;

import java.rmi.RemoteException;
import java.rmi.Remote;


import com.vutarem.common.Candidato;

import java.util.List;

public interface Servicio extends Remote {
    public boolean votar (String dni, String contraseña, int candidato) throws RemoteException;
    //Devuelve un 1 si se ha votado correctamente y un 0 si ha habido algún error
    public List<Candidato> obtenerCandidatos() throws RemoteException; 
}
