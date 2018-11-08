/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Materia {

    String ID_Materia;
    String Nombre_Materia;
    int grado;
    String Carrera;
    String Grupo;

    public Materia() {
        ID_Materia = "";
        Nombre_Materia = "";
        grado = 0;
        Carrera = "";
        Grupo = "";

    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public String getID_Materia() {
        return ID_Materia;
    }

    public void setID_Materia(String ID_Materia) {
        this.ID_Materia = ID_Materia;
    }

    public String getNombre_Materia() {
        return Nombre_Materia;
    }

    public void setNombre_Materia(String Nombre_Materia) {
        this.Nombre_Materia = Nombre_Materia;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }
}
