package com.vutarem.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//import Cliente;
//import Candidato;
import java.util.List;

import com.vutarem.common.Candidato;
import com.vutarem.cliente.Cliente;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private JList<String> listaCandidatos;
    private JTextField campoTexto1;
    private JTextField campoTexto2;
    private JButton boton;
    List<Candidato> listaCandid;
    String[] candidatos;
    // Cliente cliente = new Cliente();

    public VentanaPrincipal() {
        super("Ejemplo de interfaz gráfica con Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crea la lista de candidatos
        try {
            listaCandid = Cliente.obtenerCandidatos();
        } catch (Exception e){
            e.printStackTrace();
        }
        candidatos = new String[listaCandid.size()];
        for (int i = 0; i < listaCandid.size(); i++) {
            candidatos[i] = listaCandid.get(i).getNombre();
        }
        // String[] candidatos = {"Candidato 1", "Candidato 2", "Candidato 3",
        // "Candidato 4"};
        listaCandidatos = new JList<String>(candidatos);
        listaCandidatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaCandidatos);

        // Crea los campos de texto y el botón
        campoTexto1 = new JTextField(20);
        campoTexto2 = new JTextField(20);
        boton = new JButton("Obtener selección");
        boton.addActionListener(this);

        // Agrega los componentes a la ventana
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(scrollPane);
        panel.add(campoTexto1);
        panel.add(campoTexto2);
        panel.add(boton);
        getContentPane().add(panel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try{ 
            if (e.getSource() == boton) {
                int indice = listaCandidatos.getSelectedIndex();
                String texto1 = campoTexto1.getText();
                String texto2 = campoTexto2.getText();
                JOptionPane.showMessageDialog(this, "Candidato seleccionado: " + (indice + 1) + "\nTexto 1: " + texto1 + "\nTexto 2: " + texto2);

                Cliente cliente = new Cliente(texto1,texto2);
                for(int a=0;a<listaCandid.size();a++){
                    int votado = 0;
                    if(listaCandid.get(a).getNombre() == candidatos[indice]){
                        votado = listaCandid.get(a).getId();
                        cliente.votar(votado);
                    }
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}
