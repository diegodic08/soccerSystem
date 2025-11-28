package soccerSystem.domain;

public class Entrenador extends Persona {

    private String numeroCertificado;
    private int numeroSanciones;
    private boolean habilitado;

    public Entrenador(String nombre, String apellido, String cedula,
                      String numeroCertificado, int numeroSanciones, boolean habilitado) {
        super(nombre, apellido, cedula);
        this.numeroCertificado = numeroCertificado;
        this.numeroSanciones = numeroSanciones;
        this.habilitado = habilitado;
    }

    public String getNumeroCertificado() {
        return numeroCertificado;
    }

    public void setNumeroCertificado(String numeroCertificado) {
        this.numeroCertificado = numeroCertificado;
    }

    public int getNumeroSanciones() {
        return numeroSanciones;
    }

    public void setNumeroSanciones(int numeroSanciones) {
        this.numeroSanciones = numeroSanciones;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        if(habilitado == false) {
            throw new IllegalArgumentException("El entrenador no esta habilitado para dirijir");
        }
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "numeroCertificado='" + numeroCertificado + '\'' +
                ", numeroSanciones=" + numeroSanciones +
                ", habilitado=" + habilitado +
                '}';
    }
}
