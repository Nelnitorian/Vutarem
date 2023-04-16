package com.vutarem.cliente;

import java.rmi.*;
import java.net.MalformedURLException;
import java.util.List;

import com.vutarem.common.Candidato;
import com.vutarem.servidor.Servicio;


public class Cliente {

    private String dni;
    private String password;
    private static String HOST = "localhost";
    private static int REGISTRO = 54321;

    public Cliente (String dni, String password) {
        this.dni = dni;
        this.password = password;
    }

    public boolean votar (int idCandidato) throws RemoteException, NotBoundException, MalformedURLException {
        //Se envía al srv las credenciales y el id del candidato indicado en la interfaz gráfica por parte del votante
        Servicio srv = conexion_srv();
        return srv.votar(dni, password, idCandidato);
    }

    public static List<Candidato> obtenerCandidatos () throws RemoteException, NotBoundException, MalformedURLException {
        //Petición al srv para obtener los datos de todos los candidatos
        Servicio srv = conexion_srv();
        return srv.obtenerCandidatos();
    }

    private static Servicio conexion_srv() throws MalformedURLException, RemoteException, NotBoundException {
        //Conexión con el servidor
        return (Servicio) Naming.lookup("//" + HOST + ":" + REGISTRO + "/Vutarem");
    }
}
