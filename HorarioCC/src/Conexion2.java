
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manzana
 */
public class Conexion2 {
    private Connection conexion;
    ResultSet rs = null;
    Statement statement = null;

    public boolean conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/horariocc", "root", "root");
            if (conexion != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConexion() {

        return this.conexion;

    }

    public void desconectar() {
        try {
            this.conexion.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public ArrayList consultarClaseLunes() {
        Clase mClase = null;
        Statement consulta;
        ResultSet resultado;
        ArrayList ClaseArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from clase order by ID_Clase");
            while (resultado.next()) {
                mClase = new Clase();
                mClase.setMateria(resultado.getString("Materia"));
                mClase.setMaestro(resultado.getString("Maestro"));
                mClase.setAula(resultado.getString("Aula"));
                mClase.setHora(Integer.parseInt(resultado.getString("Hora")));
                ClaseArray.add(mClase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ClaseArray;
    }
}
