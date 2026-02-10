package unl.edu.cc.soccersystem.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import unl.edu.cc.soccersystem.domain.Campeonato;
import unl.edu.cc.soccersystem.domain.Equipo;
import unl.edu.cc.soccersystem.facade.SoccerSystemFacade;

import java.util.List;

@Named("publicoBean")
@RequestScoped
public class PublicoBean {

    @Inject
    private SoccerSystemFacade facade;

    private List<Campeonato> campeonatos;
    private List<Equipo> equipos;

    @PostConstruct
    public void init() {
        campeonatos = facade.obtenerTodosCampeonatos();
        equipos = facade.obtenerTodosEquipos();
    }

    public List<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }
}
