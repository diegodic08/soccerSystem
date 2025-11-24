package soccerSystem.domain;

import java.util.Date;

public class Partido {

    private Date fecha;
    private String idPartido;
    private String arbitro;
    private Equipo equipo1;
    private Equipo equipo2;
    private String hora;
    private EstadisticaPartido estadistica;
    private int duracion;

    public Partido() {
    }

    public Partido(Date fecha, int duracion, EstadisticaPartido estadistica,
                   String hora, Equipo equipo2, Equipo equipo1, String arbitro,
                   String idPartido) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.estadistica = estadistica;
        this.hora = hora;
        this.equipo2 = equipo2;
        this.equipo1 = equipo1;
        this.arbitro = arbitro;
        this.idPartido = idPartido;
    }

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public EstadisticaPartido getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(EstadisticaPartido estadistica) {
        this.estadistica = estadistica;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "fecha=" + fecha +
                ", idPartido='" + idPartido + '\'' +
                ", arbitro='" + arbitro + '\'' +
                ", equipo1=" + equipo1 +
                ", equipo2=" + equipo2 +
                ", hora='" + hora + '\'' +
                ", estadistica=" + estadistica +
                ", duracion=" + duracion +
                '}';
    }
}
