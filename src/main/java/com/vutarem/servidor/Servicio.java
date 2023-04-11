package com.vutarem.servidor;

import java.rmi.*;
import com.vutarem.common.Candidato;
import java.util.List;

public interface Servicio extends Remote {
	boolean votar (String dni, String password, int idCandidato) throws RemoteException;
	List <Candidato> obtenerCandidatos () throws RemoteException;
}
