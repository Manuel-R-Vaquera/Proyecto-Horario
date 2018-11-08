


import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
            consulta.execute("insert into materia (Nombre_Materia, Grado, Grupo, Carrera)"
                    + "values ('" + mMateria.getNombre_Materia() + "'," + mMateria.getGrado() + 
                    ",'" + mMateria.getGrupo() + "','"+ mMateria.getCarrera()+ "');");
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
            String cad = "update materia set "
                    + "Nombre_Materia = '" + nMateria.getNombre_Materia()
                    + "', Grado = " + nMateria.getGrado()
                    + ", Carrera = '" + nMateria.getCarrera()
                    + "', Grupo = '" + nMateria.getGrupo()
                    + "' where ID_Materia= '" + nMateria.getID_Materia() + "';";
            consulta.execute(cad);
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
    public int GuardarClase(Clase mClase) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into Clases (ID_Maestro, ID_Materia, ID_Aula, Dia, Hora) values ("
                    + "" + mClase.getMaestro()
                    + "," + mClase.getMateria()
                    + "," + mClase.getAula()
                    + ",'" + mClase.getDia()
                    + "'," + mClase.getHora() + ");");
            return 1;
        } catch (MySQLIntegrityConstraintViolationException be) {
            be.printStackTrace();
            return 3;
        
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
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

    public void CargarMaestros(JComboBox CBMaestro) {
        Statement consulta;
        
        try {
            consulta = conexion.createStatement();
            ResultSet res = null;
            res = consulta.executeQuery("SELECT Nombre_Maestro FROM maestros");
            
            CBMaestro.addItem("Seleccione un Maestro");
            while (res.next()) {
                CBMaestro.addItem(res.getString("Nombre_Maestro"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void CargarMateria(JComboBox CBMateria) {
        Statement consulta;
        
        try {
            consulta = conexion.createStatement();
            ResultSet res = null;
            res = consulta.executeQuery("SELECT Nombre_Materia FROM materia");

            CBMateria.addItem("Seleccione una Materia");
            while (res.next()) {

                CBMateria.addItem(res.getString("Nombre_Materia"));
                /*Horario mHorario = new Horario();
                mHorario.setID_Materia(Integer.parseInt("ID_Materia"));*/

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public String CargarLabelGrado(String IDM) {
        Statement consulta;
        int val;
        
        try {
            consulta = conexion.createStatement();
            ResultSet res = null;
            res = consulta.executeQuery("SELECT Grado, Carrera, Grupo FROM materia WHERE Nombre_Materia = '"+ IDM +"'");
            res.next();
            val = res.getInt("Grado");
            return ("" + val);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public String CargarLabelGrupo(String IDM) {
        Statement consulta;
        String val;
        
        try {
            consulta = conexion.createStatement();
            ResultSet res = null;
            res = consulta.executeQuery("SELECT Grado, Carrera, Grupo FROM materia WHERE Nombre_Materia = '"+ IDM +"'");
            res.next();
            val = res.getString("Grupo");
            return ("" + val);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public String CargarLabelCarrera(String IDM) {
        Statement consulta;
        String val;
        
        try {
            consulta = conexion.createStatement();
            ResultSet res = null;
            res = consulta.executeQuery("SELECT Grado, Carrera, Grupo FROM materia WHERE Nombre_Materia = '"+ IDM +"'");
            res.next();
            val = res.getString("Carrera");
            return ("" + val);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public String CargarIDMateria(String ID_Mat) {
        Statement consulta;
        int val;
        
        try {
            consulta = conexion.createStatement();
            ResultSet res = null;
            res = consulta.executeQuery("SELECT ID_Materia FROM materia WHERE Nombre_Materia = '"+ ID_Mat +"'");
            res.next();
            val = res.getInt("ID_Materia");
            return ("" + val);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public String CargarIDAula(String ID_Au) {
        Statement consulta;
        int val;
        
        try {
            consulta = conexion.createStatement();
            ResultSet res = null;
            res = consulta.executeQuery("SELECT ID_Aula FROM aula WHERE Nombre_Aula = '"+ ID_Au +"'");
            res.next();
            val = res.getInt("ID_Aula");
            return ("" + val);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public String CargarIDMaestro(String ID_Mae) {
        Statement consulta;
        int val;
        
        try {
            consulta = conexion.createStatement();
            ResultSet res = null;
            res = consulta.executeQuery("SELECT ID_Maestro FROM maestros WHERE Nombre_Maestro = '"+ ID_Mae +"'");
            res.next();
            val = res.getInt("ID_Maestro");
            return ("" + val);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public void CargarAula(JComboBox CBAula) {
        Statement consulta;
        
        try {
            consulta = conexion.createStatement();
            ResultSet res = null;
            res = consulta.executeQuery("SELECT Nombre_Aula FROM aula");

            CBAula.addItem("Seleccione un Aula");
            while (res.next()) {

                CBAula.addItem(res.getString("Nombre_Aula"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
        public ArrayList consultarMateria() {
        Materia mMateria = null;
        Statement consulta;
        ResultSet resultado;
        ArrayList MateriaArray = new ArrayList();

        try {

            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from materia order by ID_Materia");
            while (resultado.next()) {
                mMateria = new Materia();
                mMateria.setID_Materia(resultado.getString("ID_Materia"));
                mMateria.setNombre_Materia(resultado.getString("Nombre_Materia"));
                mMateria.setGrado(resultado.getInt("Grado"));
                mMateria.setGrupo(resultado.getString("Grupo"));
                mMateria.setCarrera(resultado.getString("Carrera"));
                MateriaArray.add(mMateria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return MateriaArray;
    }
        
        
}
