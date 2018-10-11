/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manzana
 */
public class Horario {
    public int ID_Materia;
    public int ID_Maestro;
    public int ID_Aula;
    public int Dia;
    public int Hora;
    
    public Horario() {
        ID_Materia = 0;
        ID_Maestro = 0;
        ID_Aula = 0;
        Dia = 0;
        Hora = 0;
    }

    public int getID_Materia() {
        return ID_Materia;
    }

    public void setID_Materia(int ID_Materia) {
        this.ID_Materia = ID_Materia;
    }

    public int getID_Maestro() {
        return ID_Maestro;
    }

    public void setID_Maestro(int ID_Maestro) {
        this.ID_Maestro = ID_Maestro;
    }

    public int getID_Aula() {
        return ID_Aula;
    }

    public void setID_Aula(int ID_Aula) {
        this.ID_Aula = ID_Aula;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int Hora) {
        this.Hora = Hora;
    }
    
    
    
}
