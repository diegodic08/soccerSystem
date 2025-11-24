package soccerSystem.domain;

import java.util.List;

public class Equipo {

    private String nombreEquipo;
    private String entrenador;
    private List<Jugador> jugadores;

    public Equipo() {
    }

    public Equipo(String nombreEquipo, String entrenador, List<Jugador> jugadores) {
        this.nombreEquipo = nombreEquipo;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
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
                ", entrenador='" + entrenador + '\'' +
                ", jugadores=" + jugadores +
                '}';
    }
}
