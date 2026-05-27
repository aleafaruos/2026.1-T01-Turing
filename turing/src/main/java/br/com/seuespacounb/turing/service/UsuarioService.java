package br.com.seuespacounb.turing.service;

import br.com.seuespacounb.turing.dto.UsuarioDTO;
import br.com.seuespacounb.turing.entity.TipoUsuario;
import br.com.seuespacounb.turing.entity.Usuario;
import br.com.seuespacounb.turing.exception.NotFoundException;
import br.com.seuespacounb.turing.exception.UnauthorizedException;
import br.com.seuespacounb.turing.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public void alterarDadosProprioUsuario(Long idUsuarioLogado, UsuarioDTO usuarioDTO) throws NotFoundException {

        Usuario usuario = usuarioRepository.findById(idUsuarioLogado)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        if (usuarioDTO.name() != null) {
            usuario.setName(usuarioDTO.name());
        }

        if (usuarioDTO.email() != null) {
            usuario.setEmail(usuarioDTO.email());
        }

        if (usuarioDTO.cpf() != null) {
            usuario.setCpf(usuarioDTO.cpf());
        }

        if (usuarioDTO.senha() != null) {
            usuario.setSenha(passwordEncoder.encode(usuarioDTO.senha()));
        }

        usuarioRepository.save(usuario);
    }

    public void deletarDadosProprioUsuario(Long idUsuarioLogado) throws NotFoundException {
        Usuario usuario = usuarioRepository.findById(idUsuarioLogado)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        usuarioRepository.delete(usuario);
    }






    public List<Usuario> getUsuarios(Long idAdm) throws NotFoundException {
        Usuario usuarioAdm = usuarioRepository.findById(idAdm)
                .orElseThrow(() -> new NotFoundException("Usuario não encontrado"));

        if (usuarioAdm.getTipoUsuario() != TipoUsuario.ADMIN) {
            throw new AccessDeniedException("Usuário não é um administrador");
        }

        return usuarioRepository.findAll();
    }

    public void admAlterarDadosUsuario(Long idAdm, Long idUsuarioPraAlterar, UsuarioDTO usuarioDTO) throws NotFoundException {
        Usuario usuarioAdm = usuarioRepository.findById(idAdm)
                .orElseThrow(() -> new NotFoundException("Usuario não encontrado"));

        Usuario usuarioCliente = usuarioRepository.findById(idUsuarioPraAlterar)
                .orElseThrow(() -> new NotFoundException("Usuario não encontrado"));

        if (usuarioAdm.getTipoUsuario() != TipoUsuario.ADMIN) {
            throw new AccessDeniedException("Usuário não é um administrador");
        }

        if (usuarioDTO.name() != null){
            usuarioCliente.setName(usuarioDTO.name());
        }

        if (usuarioDTO.email() != null){
            usuarioCliente.setEmail(usuarioDTO.email());
        }

        if (usuarioDTO.cpf() != null){
            usuarioCliente.setCpf(usuarioDTO.cpf());
        }

        if (usuarioDTO.tipoUsuario() != null) {
            usuarioCliente.setTipoUsuario(usuarioDTO.tipoUsuario());
        }

        usuarioRepository.save(usuarioCliente);
    }

    public void admDeletarUsuario(Long idAdm, Long idUsuarioDeletado) throws NotFoundException, UnauthorizedException {
        Usuario usuarioAdm = usuarioRepository.findById(idAdm)
                .orElseThrow(() -> new NotFoundException("Usuario não encontrado"));

        Usuario usuarioCliente = usuarioRepository.findById(idUsuarioDeletado)
                .orElseThrow(() -> new NotFoundException("Usuario não encontrado"));

        if (usuarioAdm.getTipoUsuario() != TipoUsuario.ADMIN) {
            throw new AccessDeniedException("Usuário não é um administrador");
        }

        if (usuarioCliente.getTipoUsuario() == TipoUsuario.ADMIN) {
            throw new UnauthorizedException("Não pode deletar um administrador");
        }


        usuarioRepository.delete(usuarioCliente);
    }

    public Usuario admEncontrarUsuarioPorEmail(Long idAdm, String email) throws NotFoundException {

        Usuario usuarioAdm = usuarioRepository.findById(idAdm)
                .orElseThrow(() -> new NotFoundException("Usuario não encontrado"));

        if (usuarioAdm.getTipoUsuario() != TipoUsuario.ADMIN) {
            throw new AccessDeniedException("Usuário não é um administrador");
        }

        Usuario usuarioCliente = usuarioRepository.findUserByEmail(email)
                .orElseThrow(() -> new NotFoundException("Usuario não encontrado"));

        return usuarioCliente;
    }
}
