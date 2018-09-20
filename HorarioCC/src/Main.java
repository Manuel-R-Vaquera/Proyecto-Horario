
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manzana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Login mLogin = new Login();
        mLogin.show();*/
        //---------------------------------------------------------------
        Conexion mConexion = new Conexion();
        mConexion.conectar();
        if (mConexion.conectar() == true) {
            JOptionPane.showMessageDialog(null, "Conexion Establecida");
        }
        else{
            JOptionPane.showMessageDialog(null, "Error de Conexion");
        }
        //---------------------------------------------------------------
        
    }
    
}
