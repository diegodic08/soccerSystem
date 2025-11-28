package soccerSystem.domain;

public class Entrenador extends Persona {

    private String numeroCertificado;
    private Sancion sancionesActuales;

    public Entrenador(String numeroCertificado, Sancion sancionesActuales) {
        this.numeroCertificado = numeroCertificado;
        this.sancionesActuales = sancionesActuales;
    }

    public Entrenador(String nombre, String apellido, String cedula,
                      String numeroCertificado, Sancion sancionesActuales) {
        super(nombre, apellido, cedula);
        this.numeroCertificado = numeroCertificado;
        this.sancionesActuales = sancionesActuales;
    }

    public boolean habilitadoDirigir(){
        return true;
    }

    public void aumentarSanciones(){

    }
    public void mostrarTotalSanciones(){

    }

    public Sancion getSancionesActuales() {
        return sancionesActuales;
    }

    public void setSancionesActuales(Sancion sancionesActuales) {
        this.sancionesActuales = sancionesActuales;
    }

    public String getNumeroCertificado() {
        return numeroCertificado;
    }

    public void setNumeroCertificado(String numeroCertificado) {
        this.numeroCertificado = numeroCertificado;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "numeroCertificado='" + numeroCertificado + '\'' +
                ", sancionesActuales=" + sancionesActuales +
                '}';
    }
}



