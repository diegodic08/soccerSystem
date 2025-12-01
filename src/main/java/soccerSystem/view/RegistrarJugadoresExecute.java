package soccerSystem.view;

import soccerSystem.domain.Equipo;
import soccerSystem.domain.Jugador;
import soccerSystem.domain.Persona;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistrarJugadoresExecute {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre del equipo: ");
        String nombreEquipo = sc.nextLine();
        System.out.println("Denominacion del equipo: ");
        String idEquipo = sc.nextLine();
        System.out.println("Color del uniforme");
        String colorUniforme = sc.nextLine();
        Equipo equipo = new Equipo(nombreEquipo, idEquipo, colorUniforme);

        boolean continuar = true;
        while (continuar) {
            while (continuar) {
                System.out.println("\n REGISTRO DE JUGADORES");
                System.out.println("Nombre del jugador: ");
                String nombre = sc.nextLine();
                System.out.println("Apellido del jugador: ");
                String apellido = sc.nextLine();
                String cedula = "";
                boolean cedulaValidada = false;
                while (!cedulaValidada) {
                    try {
                        System.out.println("Cédula del jugador: ");
                        cedula = sc.nextLine();
                        Persona.validarCedula(cedula);
                        cedulaValidada = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR: " + e.getMessage());
                        System.out.println("Intente nuevamente...\n");
                    }
                }
                int camisa = 0;
                boolean camisaValida = false;
                while (!camisaValida) {
                    try {
                        System.out.println("Número de camisa del jugador: ");
                        camisa = sc.nextInt();
                        sc.nextLine();
                        Jugador.validarNumeroCamisa(camisa);
                        camisaValida = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR: " + e.getMessage());
                        System.out.println("Intente nuevamente...\n");
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Debe ingresar SOLO números.");
                        sc.nextLine();
                    }
                }
                Jugador jugador = new Jugador(nombre, apellido, cedula, camisa);
                equipo.agregarJugador(jugador);

                System.out.print("\n¿Desea registrar otro jugador? (si/no): ");
                String opcion = sc.nextLine();
                if (opcion.equalsIgnoreCase("no")) {
                    continuar = false;
                }
            }
            equipo.mostrarJugadores();
        }
    }
}
