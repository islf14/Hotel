 package ClaseConectar;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conectar {
    static Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        Connection conectar=null;
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost/hotel_version11","root","123456");
            System.out.println("conexion establecia");
           // JOptionPane.showMessageDialog(null, "Conexion establecia");
        }catch(HeadlessException | ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion");
            JOptionPane.showMessageDialog(null, "Error de Conexion: " +e);
        }
        return conectar;
    }
    public void desconectar(){
        try{
            System.out.println("conexion cerrada");
            conectar.close();
        }catch(Exception e){        
        }
    }
}
