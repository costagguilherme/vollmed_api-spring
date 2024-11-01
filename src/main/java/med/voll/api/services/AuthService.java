package med.voll.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import med.voll.api.models.interfaces.IUsuarioRepository;


@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override // Chamado pelo AuthenticationManager
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        return this.usuarioRepository.findByLogin(username);
    }
    
}
