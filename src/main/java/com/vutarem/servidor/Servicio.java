package com.vutarem.servidor;

import java.rmi.*;
import java.rmi.server.*;

import com.vutarem.db.*;
import com.vutarem.common.*;

import java.util.List;
import java.util.ArrayList;

interface Servicio extends Remote {
    public boolean votar (String dni, String contraseña, int candidato) throws RemoteException;
    //Devuelve un 1 si se ha votado correctamente y un 0 si ha habido algún error
    public List<Candidato> obtenerCandidatos() throws RemoteException; 
}
