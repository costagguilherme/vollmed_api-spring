package med.voll.api.models.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import med.voll.api.models.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    
    UserDetails findByLogin(String login);
}
