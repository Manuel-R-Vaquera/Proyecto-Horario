


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

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
                    "jdbc:mysql://localhost:3306/horariocc", "root", "");
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

    public ArrayList consultarClaseTodas() {
        Clase mClase = null;
        Statement consulta;
        ResultSet resultado;

        ArrayList ClaseArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT * FROM Clases Natural Join maestros Natural Join aula Natural Join Materia "
                    + "Order by Dia, ID_Aula, Hora");
            while (resultado.next()) {
                mClase = new Clase();
                mClase.setHora(resultado.getInt("Hora"));
                mClase.setDia(resultado.getString("Dia"));
                mClase.setMateria(resultado.getString("Nombre_Materia"));
                mClase.setMaestro(resultado.getString("Nombre_Maestro"));
                mClase.setAula(resultado.getString("Nombre_Aula"));

                ClaseArray.add(mClase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        return ClaseArray;
    }

    public ArrayList consultarClasePorDia(String DiaSel) {
        Clase mClase = null;
        Statement consulta;
        ResultSet resultado;
        ArrayList ClaseArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT * FROM Clases Natural Join maestros Natural Join aula Natural Join materia WHERE Dia = '" + DiaSel
                    + "' Order by ID_Aula, Hora");
            while (resultado.next()) {
                mClase = new Clase();
                mClase.setHora(resultado.getInt("Hora"));
                mClase.setMateria(resultado.getString("Nombre_Materia"));
                mClase.setMaestro(resultado.getString("Nombre_Maestro"));
                mClase.setAula(resultado.getString("Nombre_Aula"));
                mClase.setGrado(resultado.getInt("Grado"));
                mClase.setCarrera(resultado.getString("Carrera"));
                mClase.setGrupo(resultado.getString("Grupo"));
                mClase.setDisponible(resultado.getString("Disponible"));
                mClase.setSuplente(resultado.getString("Suplente"));
                mClase.setID_Clase(resultado.getInt("ID_Clase"));
                
                

                //mClase.setHora(Integer.parseInt(resultado.getString("Hora")));
                ClaseArray.add(mClase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ClaseArray;
    }
    
    public ArrayList consultarClasePorAula(String AulaSel) {
        Clase mClase = null;
        Statement consulta;
        ResultSet resultado;
        ArrayList ClaseArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT * FROM Clases Natural Join maestros Natural Join aula Natural Join materia WHERE Nombre_Aula = '" + AulaSel
                    + "' Order by Dia, Hora");
            while (resultado.next()) {
                mClase = new Clase();
                mClase.setHora(resultado.getInt("Hora"));
                mClase.setMateria(resultado.getString("Nombre_Materia"));
                mClase.setMaestro(resultado.getString("Nombre_Maestro"));
                mClase.setAula(resultado.getString("Nombre_Aula"));
                mClase.setGrado(resultado.getInt("Grado"));
                mClase.setCarrera(resultado.getString("Carrera"));
                mClase.setGrupo(resultado.getString("Grupo"));
                mClase.setDia(resultado.getString("Dia"));
                mClase.setID_Clase(resultado.getInt("ID_Clase"));
                mClase.setDisponible(resultado.getString("Disponible"));
                mClase.setSuplente(resultado.getString("Suplente"));
                

                //mClase.setHora(Integer.parseInt(resultado.getString("Hora")));
                ClaseArray.add(mClase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ClaseArray;
    }
    
    public boolean EliminarClase(Clase mClase) {
        Statement consulta;

        try {
            consulta = conexion.createStatement();
            consulta.execute("delete from Clases" + 
                        " where ID_Clase = '" + mClase.getID_Clase() + "';");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
