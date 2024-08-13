package org.example.Datos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conectar = null;
    private static final String URL = "jdbc:postgresql://localhost:5432/CasaInteligente";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";


    public Connection Conectar(){
        try {
            conectar = DriverManager.getConnection(URL, USER, PASSWORD);

        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR: "+e.toString());
        }
        return conectar;
    }
}