package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dtos.AuthDto;
import med.voll.api.models.Usuario;
import med.voll.api.services.TokenService;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthDto data) {

        var token = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var authentication = manager.authenticate(token); // Chama AuthService
        var tokenJwt = tokenService.generateToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok().body(tokenJwt);
    }
}
