/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Maestro {
    
    private int ID_Maestro;
    private String Nombre_Maestro;
    
    public Maestro()
    {
        ID_Maestro = 0;
        Nombre_Maestro = "";
    }

    public int getID_Maestro() {
        return ID_Maestro;
    }

    public void setID_Maestro(int ID_Maestro) {
        this.ID_Maestro = ID_Maestro;
    }

    public String getNombre_Maestro() {
        return Nombre_Maestro;
    }

    public void setNombre_Maestro(String Nombre_Maestro) {
        this.Nombre_Maestro = Nombre_Maestro;
    }
    
}
