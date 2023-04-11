package com.vutarem.cliente;

import java.rmi.*;
import java.net.MalformedURLException;
import java.util.List;

import com.vutarem.common.Candidato;
import com.vutarem.servidor.Servicio;


public class Cliente {

    private String dni;
    private String password;
    private String HOST = "localhost";
    private int REGISTRO = 54321;
    private Servicio srv;

    public Cliente (String dni, String password) throws RemoteException, NotBoundException, MalformedURLException {
        this.dni = dni;
        this.password = password;

        if (System.getSecurityManager() == null)
        System.setSecurityManager(new SecurityManager());

        this.srv = (Servicio) Naming.lookup("//" + HOST + ":" + REGISTRO + "/Vutarem");
    }

    public void votar (int idCandidato) throws RemoteException, NotBoundException, MalformedURLException {
        //Se envía al srv las credenciales y el id del candidato indicado en la interfaz gráfica por parte del votante
        srv.votar(dni, password, idCandidato);
    }

    public List<Candidato> obtenerCandidatos () throws RemoteException, NotBoundException, MalformedURLException {
        //Petición al srv para obtener los datos de todos los candidatos
        return srv.obtenerCandidatos();
    }
}

