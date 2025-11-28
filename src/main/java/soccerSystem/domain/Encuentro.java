package soccerSystem.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Encuentro {

    private Date fecha;
    private String idPartido;
    private String arbitro;
    private Equipo visitante;
    private Equipo local;
    private String hora;
    private EstadisticaPartido estadistica;
    private int duracion;
    private List<Sancion> sanciones;


    public Encuentro(Date fecha, String arbitro, String idPartido, Equipo visitante, Equipo local,
                     String hora, EstadisticaPartido estadistica, int duracion,  List<Sancion> sanciones) {
        this.fecha = fecha;
        this.arbitro = arbitro;
        this.idPartido = idPartido;
        this.visitante = visitante;
        this.local = local;
        this.hora = hora;
        this.estadistica = estadistica;
        this.duracion = duracion;
        this.sanciones = sanciones;
    }


    /**
     * Contructuor creado para probar la funcionalidad en el main
     * @author NotElian
     * @param idPartido
     * @param fecha
     */
    public Encuentro(String idPartido, Date fecha) {
        this.idPartido = idPartido;
        this.fecha = fecha;
    }


    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public EstadisticaPartido getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(EstadisticaPartido estadistica) {
        this.estadistica = estadistica;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
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

    public List<Sancion> getSanciones() {
        return sanciones;
    }

    public void setSanciones(List<Sancion> sanciones) {
        this.sanciones = sanciones;
    }

    @Override
    public String toString() {
        return "Encuentro{" +
                "fecha=" + fecha +
                ", idPartido='" + idPartido + '\'' +
                ", arbitro='" + arbitro + '\'' +
                ", visitante=" + visitante +
                ", local=" + local +
                ", hora='" + hora + '\'' +
                ", estadistica=" + estadistica +
                ", duracion=" + duracion +
                ", sanciones=" + sanciones +
                '}';
    }
}

