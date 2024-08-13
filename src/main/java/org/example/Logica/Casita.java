package org.example.Logica;

import org.example.Datos.Conexion;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;



public class Casita {
    private String n_disp;
    private int tipo;
    Conexion con = new Conexion();

    public Casita(String n_disp, int tipo) {
        this.n_disp = n_disp;
        this.tipo = tipo;
    }

    public Casita(){

    }

    public void llenarLista(JList lista) {
        String sql = "Select d.nombre_disp, d.es_activo, d.id_disp from Tipos n join Dispositivo d on n.id_tipo = d.id_tipo";
        Statement st;

        try {
            st = con.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            DefaultListModel<String> modeloLista = new DefaultListModel<>();

            while (rs.next()) {
                String nombreDisp = rs.getString("nombre_disp");
                boolean esActivo = rs.getBoolean("es_activo");
                int idDisp = rs.getInt("id_disp");

                if (esActivo){
                    modeloLista.addElement(nombreDisp +  " (" +idDisp+") " + "Estado: Encendido");
                }

                else{
                    modeloLista.addElement(nombreDisp +  " (" +idDisp+") " + "Estado: Apagado");
                }

            }

            lista.setModel(modeloLista);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void cambiarEstado(String texto){


        int inicioParentesis = texto.indexOf("(");
        int finParentesis = texto.indexOf(")");
        String numeroStr = texto.substring(inicioParentesis + 1, finParentesis);
        int numero = Integer.parseInt(numeroStr);


        int inicioEstado = texto.indexOf("Estado: ") + "Estado: ".length();
        String estado = texto.substring(inicioEstado);

        String es_activo = "false";

        if(estado.equals("Encendido")){
            es_activo = "false";
        } else{
            es_activo = "true";
        }

        String sql = "Update Dispositivo set es_activo = "+es_activo+" where id_disp = "+ numero;
        Statement st;

        try {
            st = con.Conectar().createStatement();
            st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }




}
