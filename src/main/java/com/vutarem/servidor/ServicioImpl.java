package com.vutarem.servidor;

import java.rmi.*;
import java.rmi.server.*;

import com.vutarem.db.*;
import com.vutarem.common.*;

import java.util.List;
import java.util.ArrayList;

class ServicioImpl extends UnicastRemoteObject implements Servicio{
    ServicioImpl() throws RemoteException{ 
    }

    public boolean votar(String dni, String contrasenia, int candidato) throws RemoteException {

	CandidatoDAO candidao = new CandidatoDAO();
	VotanteDAO votdao = new VotanteDAO();
	Votante vot;
	boolean havotado;
	String contra;
	boolean correcto = true;

	try{
	vot = votdao.lee(dni);

	if(vot==null){
	    correcto = false;
	    return false;
	}
	havotado = vot.isHa_votado();
	contra = vot.getContrasenia();
	if(havotado == true || contra != contrasenia){
	    correcto = false;
	    return false;
	}

	if(candidao.lee(candidato) == null){
	    correcto = false;
	}
	if(correcto = true){
	    candidao.vota(candidato);
	    votdao.actualiza(dni, true);
	    return true;
	}
	}catch (Exception e){
            // Ignore
        }
	return false;
    }

    public List<Candidato> obtenerCandidatos() throws RemoteException{

	CandidatoDAO candidao = new CandidatoDAO();
	List<Candidato> lista;
	try{
	lista = candidao.leeTodos();
	return lista;
	}catch (Exception e){
	    // Ignore
	}
	return null;
    }
}
