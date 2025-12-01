package soccerSystem.view;

import soccerSystem.domain.*;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SoccerSystemExecute {

    private static Equipo equipoActual = new Equipo();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] arg){
        boolean exit = false;
        while(!exit){
            System.out.println("SISTEMA DE GESTION DE PARTIDOS \n");
            System.out.println("1: PARA REGISTRAR EQUIPOS Y JUGADORES");
            System.out.println("2: PARA REGISTRAR SANCIONES A UN JUGADOR");
            System.out.println("3: MOSTRAR JUGADORES DE UN EQUIPO");
            System.out.println("4: Salir");
            System.out.println("Seleccione una opcion:");

            try {
                int opcion = sc.nextInt();
                sc.nextLine();
                switch(opcion){
                    case 1:
                        RegistrarJugadoresExecute();
                        break;
                    case 2:
                        registrarSancionExecute();
                        break;
                    case 3:
                        if(equipoActual != null){
                            equipoActual.mostrarJugadores();
                        }else {
                            System.out.println("Primero debe registrar un equipo:");
                        }
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Saliendo del sistema");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            }catch (InputMismatchException e){
                System.out.println("ERROR: DEBES INGRESAR UN NUMERO ENTERO");
                sc.nextLine();
            }catch (Exception e){
                System.out.println("Ha ocurrido un error" + e.getMessage());
            }
        }
    }

    private static void RegistrarJugadoresExecute(){
        System.out.println("REGISTRANDO EQUIPO \n");
        System.out.println("Nombre del equipo. ");
        String nombreEquipo = sc.nextLine();
        System.out.println("Denominacion del equipo: ");
        String idEquipo = sc.nextLine();
        System.out.println("Color del uniforme: ");
        String colorUniforme = sc.nextLine();
        equipoActual =  new Equipo(nombreEquipo, idEquipo, colorUniforme);

        boolean agregarMasEquipos = true;
        while(agregarMasEquipos){
            try {
                System.out.println("Agregando al Jugador al equipo:" + nombreEquipo +"\n");
                System.out.println("Nombre del jugador: ");
                String nombre = sc.nextLine();
                System.out.println("Apellido del jugador: ");
                String apellido = sc.nextLine();

                String cedula = "";
                boolean cedulaValida = false;
                while (!cedulaValida){
                    try {
                        System.out.println("Cedula del jugador: ");
                        cedula = sc.nextLine();
                        Persona.validarCedula(cedula);
                        cedulaValida = true;
                    }catch (IllegalArgumentException aei){
                        System.out.println("ERROR:" +aei.getMessage() +"\n");
                    }
                }
                int numeroCamisa = 0;
                boolean numeroCamisaValida = false;
                while (!numeroCamisaValida){
                    try {
                        System.out.println("Numero de camisa del jugador (entre 0 y 99): ");
                        numeroCamisa = sc.nextInt();
                        sc.nextLine();
                        Jugador.validarNumeroCamisa(numeroCamisa);
                        numeroCamisaValida = true;
                    }catch (InputMismatchException ime){
                        System.out.println("ERROR: Debe ingresar solo numeros enteros.");
                        sc.nextLine();
                    }catch (IllegalArgumentException a){
                        System.out.println("ERROR:" +a.getMessage() +"\n");
                    }
                }
                Jugador jugador = new Jugador(nombre, apellido, cedula, numeroCamisa);
                equipoActual.agregarJugador(jugador);
            }catch (IllegalArgumentException i){
                System.out.println("Error al agregar al jugador" + i.getMessage() +"\n");
            }
            System.out.println("¿Desea registrar otro jugador? (si/no): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("no")){
                agregarMasEquipos = false;
            }
        }
    }
   private static void registrarSancionExecute(){
        if (equipoActual == null || equipoActual.getJugadores().isEmpty()){
            System.out.println("No hay equipos registrados o el equipo no tiene jugadores. " +
                    "Debe registrarlos primero (Opcion 1)");
            return;
        }
       System.out.println("REGISTRO DE SANCIONES \n");
       Encuentro encuentro = new Encuentro("Partido actual", new Date());
       System.out.println("Ingrese el numero de camisa del jugador");
       int numeroBusqueda = -1;
       try {
           numeroBusqueda = sc.nextInt();
           sc.nextLine();
       }catch (InputMismatchException ime){
           System.out.println("ERROR: Ingrese un numero valido");
           sc.nextLine();
           return;
       }
       Jugador jugadorEncontrado = null;
       for (Jugador j : equipoActual.getJugadores()) {
           if (j.getNumeroCamisa() == numeroBusqueda) {
               jugadorEncontrado = j;
               break;
           }
       }
       if(jugadorEncontrado == null){
           System.out.println("Jugador con el numero: " + numeroBusqueda +
                   " no encontrado en el equipo" + equipoActual.getNombreEquipo());
           return;
       }
       System.out.println("Ingrese el motivo de la sancion del jugador: ");
       String motivo = sc.nextLine();
       int minuto = 0;
       try {
           System.out.println("Minuto en el que se cometio la sancion");
           minuto = sc.nextInt();
           sc.nextLine();
       }catch (InputMismatchException aout){
           System.out.println("Error al ingresar el minto. Se tomara el minuto 0 como referencia");
           sc.nextLine();
       }
       TipoDeSancion tipo = TipoDeSancion.TARJETA_AMARILLA;
       System.out.println("Tipo de sancion (1. Amarilla; 2, Roja)");
       String tipoInput = sc.nextLine();
       if (tipoInput.equalsIgnoreCase("Roja")) {
           tipo = TipoDeSancion.TARJETA_ROJA;
       }

       Sancion sancion = new Sancion(minuto, jugadorEncontrado.getNumeroCamisa(),
               motivo, encuentro, tipo, true);

       jugadorEncontrado.registrarSancion(sancion);

       System.out.println("Sancion registrada correctamente");
   }
}


