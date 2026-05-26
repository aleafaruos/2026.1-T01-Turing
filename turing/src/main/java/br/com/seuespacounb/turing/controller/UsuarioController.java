package br.com.seuespacounb.turing.controller;

import br.com.seuespacounb.turing.dto.UsuarioDTO;
import br.com.seuespacounb.turing.entity.Usuario;
import br.com.seuespacounb.turing.exception.NotFoundException;
import br.com.seuespacounb.turing.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void alterarDadosUsuario(
            @AuthenticationPrincipal Usuario usuarioLogado,
            @RequestBody UsuarioDTO usuarioDTO
    ) throws NotFoundException {

        usuarioService.alterarDadosProprioUsuario(usuarioLogado.getId(), usuarioDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirDadosProprioUsuario(
            @AuthenticationPrincipal Usuario usuarioLogado
    ) throws NotFoundException {

        usuarioService.deletarDadosProprioUsuario(usuarioLogado.getId());
    }





    @GetMapping("/adm")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> admGetUsuarios(
            @AuthenticationPrincipal Usuario usuarioLogado
    ) throws NotFoundException {

        return usuarioService.getUsuarios(usuarioLogado.getId());
    }

    @PutMapping("/adm/{idUsuarioParaAlterar}")
    @ResponseStatus(HttpStatus.OK)
    public void admAlterarDadosUsuario(
            @PathVariable Long idUsuarioParaAlterar,
            @AuthenticationPrincipal Usuario usuarioLogado,
            @RequestBody UsuarioDTO usuarioDTO
    )throws NotFoundException {

        usuarioService.admAlterarDadosUsuario(
                usuarioLogado.getId(),
                idUsuarioParaAlterar,
                usuarioDTO
        );
    }

    @DeleteMapping("/adm/{idUsuarioParaDeletar}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void admDeletarUsuario(
            @PathVariable Long idUsuarioParaDeletar,
            @AuthenticationPrincipal Usuario usuarioLogado
    ) throws NotFoundException {
        usuarioService.admDeletarUsuario(usuarioLogado.getId(), idUsuarioParaDeletar);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Usuario admEncontrarUsuarioPorEmail(
            @RequestParam String email,
            @AuthenticationPrincipal Usuario usuarioLogado
    ) throws NotFoundException {
        return usuarioService.admEncontrarUsuarioPorEmail(usuarioLogado.getId(), email);
    }
}
