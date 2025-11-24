package soccerSystem.domain;

public class Jugador {

    private String nombre;
    private String apellido;
    private int numeroCamisa;
    private String cedula;

    public Jugador() {
    }

    public Jugador(String nombre, String apellido, int numeroCamisa, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCamisa = numeroCamisa;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroCamisa=" + numeroCamisa +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
