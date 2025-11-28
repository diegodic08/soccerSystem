package soccerSystem.domain;

public class Sancion {

    private int minuto;
    private String motivo;
    private Encuentro encuentro;
    private TipoDeSancion tipoDeSancion;
    private int numeroJugador;

    public Sancion() {
    }

    public Sancion(int minuto, int numeroJugador, String motivo,
                   Encuentro encuentro, TipoDeSancion tipoDeSancion) {
        this.minuto = minuto;
        this.numeroJugador = numeroJugador;
        this.motivo = motivo;
        this.encuentro = encuentro;
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

    public Encuentro getPartido() {
        return encuentro;
    }

    public void setPartido(Encuentro encuentro) {
        this.encuentro = encuentro;
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
                ", partido=" + encuentro +
                ", tipoDeSancion=" + tipoDeSancion +
                ", numeroJugador=" + numeroJugador +
                '}';
    }
}
