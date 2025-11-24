package soccerSystem.domain;

public class Sancion {

    private int minuto;
    private String motivo;
    private Partido partido;
    private TipoDeSancion tipoDeSancion;
    private int numeroJugador;

    public Sancion() {
    }

    public Sancion(int minuto, int numeroJugador, String motivo,
                              Partido partido, TipoDeSancion tipoDeSancion) {
        this.minuto = minuto;
        this.numeroJugador = numeroJugador;
        this.motivo = motivo;
        this.partido = partido;
        this.tipoDeSancion = tipoDeSancion;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public TipoDeSancion getTipoDeSancion() {
        return tipoDeSancion;
    }

    public void setTipoDeSancion(TipoDeSancion tipoDeSancion) {
        this.tipoDeSancion = tipoDeSancion;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }

    public void setNumeroJugador(int numeroJugador) {
        this.numeroJugador = numeroJugador;
    }

    @Override
    public String toString() {
        return "EstadisticaPartido{" +
                "minuto=" + minuto +
                ", motivo='" + motivo + '\'' +
                ", partido=" + partido +
                ", tipoDeSancion=" + tipoDeSancion +
                ", numeroJugador=" + numeroJugador +
                '}';
    }
}
