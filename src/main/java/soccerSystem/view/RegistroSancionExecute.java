package soccerSystem.view;

import soccerSystem.domain.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistroSancionExecute {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Encuentro encuentro = new Encuentro("primera fecha", new Date());

        System.out.println("Nombre del jugador: ");
        String nombre = sc.nextLine();
        System.out.println("Apellido del jugador: ");
        String apellido = sc.nextLine();

        String cedula = "";
        boolean cedulaValidada = false;
        while (!cedulaValidada) {
            try {
                System.out.println("Cedula del jugador: ");
                cedula = sc.nextLine();
                Persona.validarCedula(cedula);
                cedulaValidada = true;
            } catch (IllegalArgumentException aei) {
                System.out.println("Ha ocurrido un Error " +"\n"+ aei.getMessage() );
                System.out.println("Intente nuevamente");
            }
        }

        int camisa = 0;
        boolean camisaValida = false;
        while (!camisaValida) {
            try {
                System.out.println("Numero de Camisa del Jugador: ");
                camisa = sc.nextInt();
                Jugador.validarNumeroCamisa(camisa);
                camisaValida = true;
            } catch (IllegalArgumentException aie) {
                System.out.println("Ha ocurrido un Error" +"\n"+ aie.getMessage());
                System.out.println("Intente nuevamente");
            } catch (InputMismatchException ea) {
                System.out.println("ERROR: Debe ingresar SOLO números");
                sc.nextLine();
            }
        }
        Jugador jugador = new Jugador(nombre,apellido,cedula,camisa);
        Sancion sancion = new Sancion(45, camisa,"FALTA ANTIDEPORTIVA",
                encuentro,TipoDeSancion.TARJETA_ROJA, false);

        jugador.registrarSancion(sancion);
    }
}
