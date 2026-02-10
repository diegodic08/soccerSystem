package unl.edu.cc.soccersystem.controller;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import unl.edu.cc.soccersystem.domain.AdminUsuario;
import unl.edu.cc.soccersystem.repository.AdminUsuarioRepository;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Named("adminBean")
@SessionScoped
public class AdminBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_ADMIN_USERNAME = "admin";
    private static final String DEFAULT_ADMIN_PASSWORD = "admin123";

    @Inject
    private AdminUsuarioRepository adminUsuarioRepository;

    private String username;
    private String password;
    private boolean adminAutenticado;

    public String login() {
        try {
            if (username == null || username.trim().isEmpty()
                    || password == null || password.isEmpty()) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "Debe ingresar usuario y contrasena");
                return null;
            }

            if (!ensureDefaultAdminSafe()) {
                return null;
            }

            AdminUsuario admin = adminUsuarioRepository.findByUsername(username.trim());
            if (admin == null || !admin.getPasswordHash().equals(hashPassword(password))) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "Credenciales invalidas");
                return null;
            }

            adminAutenticado = true;
            password = null;
            return "campeonatos?faces-redirect=true";
        } catch (Exception e) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "No se pudo iniciar sesion: " + e.getMessage());
            return null;
        }
    }

    public String logout() {
        adminAutenticado = false;
        username = null;
        password = null;
        return "index?faces-redirect=true";
    }

    public boolean isAdminAutenticado() {
        return adminAutenticado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(severity, summary, detail));
    }

    private boolean ensureDefaultAdminSafe() {
        try {
            adminUsuarioRepository.ensureDefaultAdmin(
                    DEFAULT_ADMIN_USERNAME,
                    hashPassword(DEFAULT_ADMIN_PASSWORD));
            return true;
        } catch (Exception e) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "No se pudo conectar a la base de datos para validar el admin");
            return false;
        }
    }

    private static String hashPassword(String raw) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(raw.getBytes(StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            for (byte b : hash) {
                builder.append(String.format("%02x", b));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Algoritmo de hash no disponible", e);
        }
    }
}
