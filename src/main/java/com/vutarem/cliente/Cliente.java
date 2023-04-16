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

    public void votar (int idCandidato) throws RemoteException, NotBoundException, MalformedURLException {
        //Se envía al srv las credenciales y el id del candidato indicado en la interfaz gráfica por parte del votante
        conexion_srv();
        srv.votar(dni, password, idCandidato);
    }

    public static List<Candidato> obtenerCandidatos () throws RemoteException, NotBoundException, MalformedURLException {
        //Petición al srv para obtener los datos de todos los candidatos
        conexion_srv();
        return srv.obtenerCandidatos();
    }

    private static void conexion_srv() {
        //Conexión con el servidor
        Servicio srv = (Servicio) Naming.lookup("//" + HOST + ":" + REGISTRO + "/Vutarem");
    }
}
