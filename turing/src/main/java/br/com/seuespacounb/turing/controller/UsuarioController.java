package br.com.seuespacounb.turing.controller;

import br.com.seuespacounb.turing.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    //cadastra novo usuario
    @PostMapping
    public ResponseEntity<?> cadastrar() {
        return null;
    }

    //retorna o usuario por ‘id’
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId() {
        return null; //temporario, apenas para compor o esqueleto antes da implementação real

    }

    //retorna lista de usuarios
    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        return null;
    }

    //atualiza os dados do usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar() {
        return null;
    }

    //remove o usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario() {
        return null;
    }
}
