package soccerSystem.domain;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

    private String nombreEquipo;
    private String idEquipo;
    private String colorUniforme;
    private List<Jugador> jugadores;

    public Equipo() {
    }

    public Equipo(String nombreEquipo,String idEquipo, String colorUniforme) {
        this.nombreEquipo = nombreEquipo;
        this.idEquipo = idEquipo;
        this.colorUniforme = colorUniforme;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
       for (Jugador j : jugadores){
           if (j.getNombre().equals(jugador.getNombre())){
               throw new IllegalArgumentException("El Jugador ya se encuentra registrado");
           }
       }
       jugadores.add(jugador);
        System.out.println("Jugador registrado correctamente");
    }

    public void mostrarJugadores(){
        System.out.println("Jugadores del equip:" +nombreEquipo + ":");
        for (Jugador j : jugadores){
            System.out.println(j);
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

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombreEquipo='" + nombreEquipo + '\'' +
                ", colorUniforme='" + colorUniforme + '\'' +
                '}';
    }
}
