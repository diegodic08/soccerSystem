package soccerSystem.view;

import soccerSystem.domain.Equipo;
import soccerSystem.domain.Jugador;

public class RegistrarJugadoresExecute {

    public static void main(String[] args) {

        Equipo equipo1 = new Equipo("Barcelona", "Visitante", "Rojo");
        Jugador jugador = new Jugador("Alex", "Bravo", "1900337080", 8);
        equipo1.agregarJugador(jugador);
        equipo1.mostrarJugadores();
    }
}
