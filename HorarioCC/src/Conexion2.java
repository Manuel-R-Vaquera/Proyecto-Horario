
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

    public ArrayList consultarClaseTodas() {
        Clase mClase = null;
        Statement consulta;
        ResultSet resultado;
        ArrayList ClaseArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT * FROM Lunes "
                    + "UNION ALL "
                    + "SELECT * FROM Martes "
                    + "UNION ALL "
                    + "SELECT * FROM Miercoles "
                    + "UNION ALL "
                    + "SELECT * FROM Jueves "
                    + "UNION ALL "
                    + "SELECT * FROM Viernes "
                    + "GROUP BY Dia");
            while (resultado.next()) {
                mClase = new Clase();
                mClase.setHora(resultado.getInt("Hora"));
                mClase.setDia(resultado.getString("Dia"));
                mClase.setMateria(resultado.getString("Materia"));
                mClase.setMaestro(resultado.getString("Maestro"));
                mClase.setAula(resultado.getString("Aula"));

                //mClase.setHora(Integer.parseInt(resultado.getString("Hora")));
                ClaseArray.add(mClase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ClaseArray;
    }

    public ArrayList consultarClaseLunes() {
        Clase mClase = null;
        Statement consulta;
        ResultSet resultado;
        ArrayList ClaseArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from Lunes ORDER BY Hora");
            while (resultado.next()) {
                mClase = new Clase();
                mClase.setHora(resultado.getInt("Hora"));
                mClase.setMateria(resultado.getString("Materia"));
                mClase.setMaestro(resultado.getString("Maestro"));
                mClase.setAula(resultado.getString("Aula"));

                //mClase.setHora(Integer.parseInt(resultado.getString("Hora")));
                ClaseArray.add(mClase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ClaseArray;
    }

    public ArrayList consultarClaseMartes() {
        Clase mClase = null;
        Statement consulta;
        ResultSet resultado;
        ArrayList ClaseArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from Martes ORDER BY Hora");
            while (resultado.next()) {
                mClase = new Clase();
                mClase.setHora(resultado.getInt("Hora"));
                mClase.setMateria(resultado.getString("Materia"));
                mClase.setMaestro(resultado.getString("Maestro"));
                mClase.setAula(resultado.getString("Aula"));

                //mClase.setHora(Integer.parseInt(resultado.getString("Hora")));
                ClaseArray.add(mClase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ClaseArray;
    }

    public ArrayList consultarClaseMiercoles() {
        Clase mClase = null;
        Statement consulta;
        ResultSet resultado;
        ArrayList ClaseArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from Miercoles ORDER BY Hora");
            while (resultado.next()) {
                mClase = new Clase();
                mClase.setHora(resultado.getInt("Hora"));
                mClase.setMateria(resultado.getString("Materia"));
                mClase.setMaestro(resultado.getString("Maestro"));
                mClase.setAula(resultado.getString("Aula"));

                //mClase.setHora(Integer.parseInt(resultado.getString("Hora")));
                ClaseArray.add(mClase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ClaseArray;
    }

    public ArrayList consultarClaseJueves() {
        Clase mClase = null;
        Statement consulta;
        ResultSet resultado;
        ArrayList ClaseArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from Jueves ORDER BY Hora");
            while (resultado.next()) {
                mClase = new Clase();
                mClase.setHora(resultado.getInt("Hora"));
                mClase.setMateria(resultado.getString("Materia"));
                mClase.setMaestro(resultado.getString("Maestro"));
                mClase.setAula(resultado.getString("Aula"));

                //mClase.setHora(Integer.parseInt(resultado.getString("Hora")));
                ClaseArray.add(mClase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ClaseArray;
    }

    public ArrayList consultarClaseViernes() {
        Clase mClase = null;
        Statement consulta;
        ResultSet resultado;
        ArrayList ClaseArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from Viernes ORDER BY Hora");
            while (resultado.next()) {
                mClase = new Clase();
                mClase.setHora(resultado.getInt("Hora"));
                mClase.setMateria(resultado.getString("Materia"));
                mClase.setMaestro(resultado.getString("Maestro"));
                mClase.setAula(resultado.getString("Aula"));

                //mClase.setHora(Integer.parseInt(resultado.getString("Hora")));
                ClaseArray.add(mClase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ClaseArray;
    }

}
