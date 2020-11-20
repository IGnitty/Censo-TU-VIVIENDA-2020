/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package censo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author lemus
 */
public class ConectarBD {
    
    public static Connection conectar;
    
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DBNAME = "censadodb";
    private static final String url = "jdbc:mysql://localhost:3306/" + DBNAME + "?useSSL=false&serverTimezone=GMT-4";
    
    public ConectarBD(){
        conectar = null;
    }
    
    public Connection abrirConexion(){
        try{
            conectar = DriverManager.getConnection(url, USER, PASSWORD);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error de conexion con la base de datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return conectar;
    }
    
    public void cerrarConexion(){
        try{
            conectar.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error al cerrar la conexion con la base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }
}
