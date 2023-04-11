En esta carpeta trabajará Juanjo la parte de base de datos de java.

# Login y voto

```
VotanteDAO votdao = new VotanteDAO();
CandidatoDAO candao = new CandidatoDAO();
Votante vot = votdao.lee(dni);
if (contrasenia.equals(vot.getContrasenia())){
    // Login exitoso
    votdao.actualiza(dni, true);
    candao.vota(id);
} else{
    // Login fracasado
}
```

TODO: 
1. Interfaz de VotanteDAO (llamada IVotanteDAO). 
2. Candidato (db y bean), CandidatoDAO y ICandidatoDAO.