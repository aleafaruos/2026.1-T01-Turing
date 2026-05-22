package br.com.seuespacounb.turing.controller;

import br.com.seuespacounb.turing.dto.request.LoginRequest;
import br.com.seuespacounb.turing.dto.request.RegisterUserRequest;
import br.com.seuespacounb.turing.dto.response.LoginResponse;
import br.com.seuespacounb.turing.dto.response.RegisterUserResponse;
import br.com.seuespacounb.turing.entity.Usuario;
import br.com.seuespacounb.turing.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request) {
        Usuario novoUsuario = new Usuario();

        novoUsuario.setName(request.name());
        novoUsuario.setEmail(request.email());
        novoUsuario.setCpf(request.cpf());
        novoUsuario.setSenha(passwordEncoder.encode(request.password()));
        novoUsuario.setTipoUsuario(request.tipoUsuario());

        usuarioRepository.save(novoUsuario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RegisterUserResponse(novoUsuario.getName(), novoUsuario.getEmail()));
    }
}
