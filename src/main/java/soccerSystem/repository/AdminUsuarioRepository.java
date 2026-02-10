package unl.edu.cc.soccersystem.repository;

import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import unl.edu.cc.soccersystem.domain.AdminUsuario;

@jakarta.enterprise.context.ApplicationScoped
public class AdminUsuarioRepository extends GenericRepositoryIpm<AdminUsuario, Long> {

    public AdminUsuarioRepository() {
        super(AdminUsuario.class);
    }

    public AdminUsuario findByUsername(String username) {
        TypedQuery<AdminUsuario> query = getEntityManager().createQuery(
                "SELECT a FROM AdminUsuario a WHERE a.username = :username",
                AdminUsuario.class);
        query.setParameter("username", username);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Transactional
    public AdminUsuario ensureDefaultAdmin(String username, String passwordHash) {
        ensureTableExists();
        AdminUsuario existing = findByUsername(username);
        if (existing != null) {
            return existing;
        }
        AdminUsuario admin = new AdminUsuario(username, passwordHash);
        return save(admin);
    }

    private void ensureTableExists() {
        getEntityManager().createNativeQuery(
                "CREATE TABLE IF NOT EXISTS admin_usuarios (" +
                        "id BIGSERIAL PRIMARY KEY," +
                        "username VARCHAR(50) NOT NULL UNIQUE," +
                        "password_hash VARCHAR(64) NOT NULL," +
                        "created_at TIMESTAMP NOT NULL DEFAULT NOW()" +
                        ")")
                .executeUpdate();
    }
}
