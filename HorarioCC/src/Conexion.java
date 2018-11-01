
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
            consulta.execute("insert into materia (Nombre_Materia, Grado, Carrera)"
                    + "values ('" + mMateria.getNombre_Materia() + "'," + mMateria.getGrado() + 
                    ",'"+ mMateria.getCarrera()+ "');");
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
            consulta.execute("update materia set "
                    + "Nombre_Materia = '" + nMateria.getNombre_Materia()
                    + "', Grado = " + nMateria.getGrado()
                    + ", Carrera = '" + nMateria.getCarrera()
                    + "' where ID_Materia= '" + mMateria.getID_Materia() + "';");
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
    public int GuardarClaseLunes(Clase mClase) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into Lunes (Maestro, Materia, Aula, Hora) values ("
                    + "'" + mClase.getMaestro()
                    + "','" + mClase.getMateria()
                    + "','" + mClase.getAula()
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
    
    public int GuardarClaseMartes(Clase mClase) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into Martes (Maestro, Materia, Aula, Hora) values ("
                    + "'" + mClase.getMaestro()
                    + "','" + mClase.getMateria()
                    + "','" + mClase.getAula()
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
    
    public int GuardarClaseMiercoles(Clase mClase) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into Miercoles (Maestro, Materia, Aula, Hora) values ("
                    + "'" + mClase.getMaestro()
                    + "','" + mClase.getMateria()
                    + "','" + mClase.getAula()
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
    
    public int GuardarClaseJueves(Clase mClase) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into Jueves (Maestro, Materia, Aula, Hora) values ("
                    + "'" + mClase.getMaestro()
                    + "','" + mClase.getMateria()
                    + "','" + mClase.getAula()
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
    
    public int GuardarClaseViernes(Clase mClase) {
        Statement consulta;
        try {
            consulta = conexion.createStatement();
            consulta.execute("insert into Viernes (Maestro, Materia, Aula, Hora) values ("
                    + "'" + mClase.getMaestro()
                    + "','" + mClase.getMateria()
                    + "','" + mClase.getAula()
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
                mMateria.setCarrera(resultado.getString("Carrera"));
                MateriaArray.add(mMateria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return MateriaArray;
    }
        
}
