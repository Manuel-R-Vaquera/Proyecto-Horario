
/**
 *
 * @author manzana
 */
public class Clase {
    public int ID_Clase;
    public String Maestro;
    public String Materia;
    public String Aula;
    public String Dia;
    public int Hora;
    public String Grupo;
    public int Grado;
    public String Carrera;
    public String Disponible;
    public String Suplente;

    public Clase() {
        Maestro = "";
        Materia = "";
        Aula = "";
        Dia = "";
        Hora = 0;
        Grupo = "";
        Grado = 0;
        Carrera = "";
        ID_Clase = 0;
        Disponible = "";
        Suplente = "";
    }

    public String getSuplente() {
        return Suplente;
    }

    public void setSuplente(String Suplente) {
        this.Suplente = Suplente;
    }

    public String getDisponible() {
        return Disponible;
    }

    public void setDisponible(String Disponible) {
        this.Disponible = Disponible;
    }

    public int getID_Clase() {
        return ID_Clase;
    }

    public void setID_Clase(int ID_Clase) {
        this.ID_Clase = ID_Clase;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public int getGrado() {
        return Grado;
    }

    public void setGrado(int Grado) {
        this.Grado = Grado;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public String getMaestro() {
        return Maestro;
    }

    public void setMaestro(String Maestro) {
        this.Maestro = Maestro;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }

    public String getAula() {
        return Aula;
    }

    public void setAula(String Aula) {
        this.Aula = Aula;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String Dia) {
        this.Dia = Dia;
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int Hora) {
        this.Hora = Hora;
    }
    
    
    
    
}
