
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
 * @author PC
 */
public class Conexion {

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

    //Catalogo Maestros//
    public boolean GuardarMaestro(Maestro mMaestro) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("INSERT INTO maestros (Nombre_Maestro)"
                    + "VALUES('" + mMaestro.getNombre_Maestro() + "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarMaestro(Maestro mMaestro) {
        Statement consulta;

        try {
            consulta = conexion.createStatement();
            consulta.execute("delete from maestros " + " where ID_Maestro = '" + mMaestro.getID_Maestro() + "';");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarMaestro(Maestro mMaestro, Maestro nMaestro) {
        Statement consulta;

        try {
            consulta = conexion.createStatement();
            consulta.execute("update maestros set "
                    + "Nombre_Maestro = '" + nMaestro.getNombre_Maestro()
                    + "' where ID_Maestro= '" + mMaestro.getID_Maestro() + "';");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    ///Catalogo Materia///
    public boolean GuardarMateria(Materia mMateria) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into materia (Nombre_Materia)"
                    + "values ('" + mMateria.getNombre_Materia() + "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarMateria(Materia mMateria) {
        Statement consulta;

        try {
            consulta = conexion.createStatement();
            consulta.execute("delete from materia " + " where ID_Materia = '" + mMateria.getID_Materia() + "';");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarMateria(Materia mMateria, Materia nMateria) {
        Statement consulta;

        try {
            consulta = conexion.createStatement();
            consulta.execute("update materia set " + "Nombre_Materia = '" + nMateria.getNombre_Materia() + "'," + "Grado = '" + nMateria.getGrado() + "'" + "Carrera = '" + nMateria.getCarrera() + "WHERE ID_Materia = '" + mMateria.getID_Materia() + "';");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Catalogo aula//
    public boolean GuardarAula(Aula mAula) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into aula (Nombre_Aula)"
                    + "values ('" + mAula.getNombre_Aula() + "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarAula(Aula mAula) {
        Statement consulta;

        try {
            consulta = conexion.createStatement();
            consulta.execute("delete from aula " + " where ID_Aula = '" + mAula.getID_Aula() + "';");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarAula(Aula mAula, Aula nAula) {
        Statement consulta;

        try {
            consulta = conexion.createStatement();
            consulta.execute("update aula set "
                    + "Nombre_Aula = '" + nAula.getNombre_Aula()
                    + "' where ID_Aula= '" + mAula.getID_Aula() + "';");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList consultarMaestro() {
        Maestro mMaestro = null;
        Statement consulta;
        ResultSet resultado;
        ArrayList MaestroArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from maestros order by ID_Maestro");
            while (resultado.next()) {
                mMaestro = new Maestro();
                mMaestro.setID_Maestro(resultado.getString("ID_Maestro"));
                mMaestro.setNombre_Maestro(resultado.getString("Nombre_Maestro"));
                MaestroArray.add(mMaestro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return MaestroArray;
    }

    public ArrayList consultarAula() {
        Aula mAula = null;
        Statement consulta;
        ResultSet resultado;
        ArrayList AulaArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from aula order by ID_Aula");
            while (resultado.next()) {
                mAula = new Aula();
                mAula.setID_Aula(resultado.getString("ID_Aula"));
                mAula.setNombre_Aula(resultado.getString("Nombre_Aula"));
                AulaArray.add(mAula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return AulaArray;
    }
}
