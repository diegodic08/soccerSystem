package soccerSystem.domain;

public class Jugador extends Persona {

    private int numeroCamisa;

    public Jugador(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public Jugador(String nombre, String apellido, String cedula, int numeroCamisa) {
        super(nombre, apellido, cedula);
        this.numeroCamisa = numeroCamisa;
    }

    public static void validarNumeroCamisa(int numeroCamisa) {
        if(numeroCamisa < 0 || numeroCamisa > 99){
            throw new IllegalArgumentException("El numero de camisa no cumple con el formato");
        }
    }

    public void registrarSancion(Sancion sancion) {
        System.out.println("Sancion registrada para el jugador: " +getNombre() + "\n");
        System.out.println("Tipo: " +sancion.getTipoDeSancion() + "\n");
        System.out.println("Motivo: " +sancion.getMotivo().toUpperCase() + "\n");
        System.out.println("Minuto en el que se cometido la sancion: " +sancion.getMinuto() + "\n");
    }


    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    @Override
    public String toString() {
        return "Jugador: " + getNombre() + " " + getApellido() +
                " | Cédula: " + getCedula() +
                " | Nº Camisa: " + numeroCamisa;
    }
}
