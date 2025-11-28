package soccerSystem.domain;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

    private String nombreEquipo;
    private String idEquipo;
    private String colorUniforme;
    private Jugador jugador;

    public Equipo() {
    }

    public Equipo(String nombreEquipo,String idEquipo, String colorUniforme) {
        this.nombreEquipo = nombreEquipo;
        this.idEquipo = idEquipo;
        this.colorUniforme = colorUniforme;
    }

    public void agregarJugador(Jugador jugador) {
        this.jugador = jugador;
        System.out.println("Jugador registrado en el equipo: " + nombreEquipo  + "\n");
        System.out.println("Nombre del jugador: " + jugador.getNombre()  + "\n") ;
    }

    public void mostrarJugadores(){
        if(jugador != null){
            System.out.println("Jugador del equipo: " + nombreEquipo  + "\n");
            System.out.println(jugador  + "\n");;
        }
        else {
            System.out.println("No hay jugadores registros en el equipo");
        }
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getColorUniforme() {
        return colorUniforme;
    }

    public void setColorUniforme(String colorUniforme) {
        this.colorUniforme = colorUniforme;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombreEquipo='" + nombreEquipo + '\'' +
                ", colorUniforme='" + colorUniforme + '\'' +
                '}';
    }
}
