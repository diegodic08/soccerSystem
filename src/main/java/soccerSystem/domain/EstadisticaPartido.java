package soccerSystem.domain;

public class EstadisticaPartido {

    private String marcadorFinal;
    private int tirosAlArco;
    private int faltasCometidas;
    private int tarjetasAmarillas;
    private int tarjetasRojas;
    private int corners;
    private String minutoAccion;
    private int totalDeCambios;

    public EstadisticaPartido() {
    }

    public EstadisticaPartido(String marcadorFinal, int totalDeCambios, String minutoAccion,
                              int corners, int tarjetasAmarillas, int tarjetasRojas, int faltasCometidas,
                              int tirosAlArco) {
        this.marcadorFinal = marcadorFinal;
        this.totalDeCambios = totalDeCambios;
        this.minutoAccion = minutoAccion;
        this.corners = corners;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
        this.faltasCometidas = faltasCometidas;
        this.tirosAlArco = tirosAlArco;
    }

    public String getMarcadorFinal() {
        return marcadorFinal;
    }

    public void setMarcadorFinal(String marcadorFinal) {
        this.marcadorFinal = marcadorFinal;
    }

    public int getTirosAlArco() {
        return tirosAlArco;
    }

    public void setTirosAlArco(int tirosAlArco) {
        this.tirosAlArco = tirosAlArco;
    }

    public int getFaltasCometidas() {
        return faltasCometidas;
    }

    public void setFaltasCometidas(int faltasCometidas) {
        this.faltasCometidas = faltasCometidas;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }

    public int getCorners() {
        return corners;
    }

    public void setCorners(int corners) {
        this.corners = corners;
    }

    public String getMinutoAccion() {
        return minutoAccion;
    }

    public void setMinutoAccion(String minutoAccion) {
        this.minutoAccion = minutoAccion;
    }

    public int getTotalDeCambios() {
        return totalDeCambios;
    }

    public void setTotalDeCambios(int totalDeCambios) {
        this.totalDeCambios = totalDeCambios;
    }

    @Override
    public String toString() {
        return "EstadisticaPartido{" +
                "marcadorFinal='" + marcadorFinal + '\'' +
                ", tirosAlArco=" + tirosAlArco +
                ", faltasCometidas=" + faltasCometidas +
                ", tarjetasAmarillas=" + tarjetasAmarillas +
                ", tarjetasRojas=" + tarjetasRojas +
                ", corners=" + corners +
                ", minutoAccion='" + minutoAccion + '\'' +
                ", totalDeCambios=" + totalDeCambios +
                '}';
    }
}
