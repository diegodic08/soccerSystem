package unl.edu.cc.soccersystem.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import unl.edu.cc.soccersystem.domain.Jugador;
import unl.edu.cc.soccersystem.facade.SoccerSystemFacade;
import unl.edu.cc.soccersystem.repository.JugadorRepository;

import java.io.Serializable;

@Named("jugadorBean")
@SessionScoped
public class JugadorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EquipoBean equipoBean;

    @Inject
    private SoccerSystemFacade facade;

    @Inject
    private JugadorRepository jugadorRepository;

    @Inject
    private AdminBean adminBean;

    private Jugador jugador;
    private Jugador jugadorSeleccionado;
    private boolean mostrarFormulario;

    @PostConstruct
    public void init() {
        this.jugador = new Jugador();
        this.mostrarFormulario = false;
    }

    /**
     * Agrega un nuevo jugador al equipo
     */
    public String agregarJugador() {
        try {
            if (!validarAdmin()) {
                return null;
            }
            if (equipoBean.getEquipoSeleccionado() == null) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "No hay equipo seleccionado");
                return null;
            }

            // Validaciones básicas
            if (jugador.getNombre() == null || jugador.getNombre().trim().isEmpty()) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "El nombre del jugador es obligatorio");
                return null;
            }

            if (jugador.getApellido() == null || jugador.getApellido().trim().isEmpty()) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "El apellido del jugador es obligatorio");
                return null;
            }

            if (jugador.getCedula() == null || jugador.getCedula().trim().isEmpty()) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "La cédula del jugador es obligatoria");
                return null;
            }

            Jugador.validarCedula(jugador.getCedula());
            Jugador.validarNumeroCamisa(jugador.getNumeroCamisa());

            // Crear jugador usando el facade
            facade.crearJugador(
                    jugador.getNombre(),
                    jugador.getApellido(),
                    jugador.getCedula(),
                    jugador.getNumeroCamisa(),
                    equipoBean.getEquipoSeleccionado().getId());

            addMessage(FacesMessage.SEVERITY_INFO, "Éxito",
                    "Jugador agregado exitosamente");

            // Recargar equipo con jugadores
            equipoBean.setEquipoSeleccionado(
                    facade.obtenerEquipoConJugadores(
                            equipoBean.getEquipoSeleccionado().getId()));

            // Resetear formulario
            jugador = new Jugador();
            mostrarFormulario = false;

            return null;
        } catch (IllegalArgumentException e) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error de validación", e.getMessage());
            return null;
        } catch (Exception e) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Error al agregar jugador: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void prepararEditar(Jugador j) {
        this.jugadorSeleccionado = j;
    }

    public void actualizarJugador() {
        try {
            if (!validarAdmin()) {
                return;
            }
            if (jugadorSeleccionado == null) {
                return;
            }
            if (equipoBean.getEquipoSeleccionado() == null) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "No hay equipo seleccionado");
                return;
            }

            if (jugadorSeleccionado.getNombre() == null
                    || jugadorSeleccionado.getNombre().trim().isEmpty()) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "El nombre del jugador es obligatorio");
                return;
            }

            if (jugadorSeleccionado.getApellido() == null
                    || jugadorSeleccionado.getApellido().trim().isEmpty()) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "El apellido del jugador es obligatorio");
                return;
            }

            if (jugadorSeleccionado.getCedula() == null
                    || jugadorSeleccionado.getCedula().trim().isEmpty()) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "La cédula del jugador es obligatoria");
                return;
            }

            Jugador.validarCedula(jugadorSeleccionado.getCedula());
            Jugador.validarNumeroCamisa(jugadorSeleccionado.getNumeroCamisa());

            Jugador existente = jugadorRepository.findByCedula(jugadorSeleccionado.getCedula());
            if (existente != null && !existente.getId().equals(jugadorSeleccionado.getId())) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "Ya existe un jugador con esa cédula");
                return;
            }

            Long equipoId = equipoBean.getEquipoSeleccionado().getId();
            if (jugadorRepository.existeNumeroCamisaEnEquipo(
                    equipoId,
                    jugadorSeleccionado.getNumeroCamisa(),
                    jugadorSeleccionado.getId())) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "Ya existe un jugador con ese número de camisa en el equipo");
                return;
            }

            facade.actualizarJugador(jugadorSeleccionado);

            equipoBean.setEquipoSeleccionado(
                    facade.obtenerEquipoConJugadores(equipoId));

            addMessage(FacesMessage.SEVERITY_INFO, "Éxito",
                    "Jugador actualizado correctamente");
        } catch (Exception e) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Error al actualizar jugador: " + e.getMessage());
        }
    }

    public void eliminarJugador(Jugador j) {
        try {
            if (!validarAdmin()) {
                return;
            }
            if (j == null) {
                return;
            }
            facade.eliminarJugador(j.getId());
            if (equipoBean.getEquipoSeleccionado() != null) {
                equipoBean.setEquipoSeleccionado(
                        facade.obtenerEquipoConJugadores(
                                equipoBean.getEquipoSeleccionado().getId()));
            }
            addMessage(FacesMessage.SEVERITY_INFO, "Éxito",
                    "Jugador eliminado correctamente");
        } catch (Exception e) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Error al eliminar jugador: " + e.getMessage());
        }
    }

    /**
     * Cancela la creación de jugador
     */
    public void cancelar() {
        jugador = new Jugador();
        mostrarFormulario = false;
    }

    /**
     * Muestra el formulario para agregar un nuevo jugador
     */
    public void mostrarFormularioNuevo() {
        jugador = new Jugador();
        mostrarFormulario = true;
    }

    /**
     * Vuelve a la pantalla de equipos
     */
    public String volverAEquipos() {
        equipoBean.setEquipoSeleccionado(null);
        return "equipos?faces-redirect=true";
    }

    /**
     * Agrega un mensaje al contexto de JSF
     */
    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(severity, summary, detail));
    }

    private boolean validarAdmin() {
        if (adminBean != null && adminBean.isAdminAutenticado()) {
            return true;
        }
        addMessage(FacesMessage.SEVERITY_ERROR, "Acceso restringido",
                "Debe iniciar sesion como administrador");
        return false;
    }

    // Getters y Setters
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugadorSeleccionado() {
        return jugadorSeleccionado;
    }

    public void setJugadorSeleccionado(Jugador jugadorSeleccionado) {
        this.jugadorSeleccionado = jugadorSeleccionado;
    }

    public boolean isMostrarFormulario() {
        return mostrarFormulario;
    }

    public void setMostrarFormulario(boolean mostrarFormulario) {
        this.mostrarFormulario = mostrarFormulario;
    }
}
