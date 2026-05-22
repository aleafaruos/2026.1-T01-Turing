package br.com.seuespacounb.turing.config;

import br.com.seuespacounb.turing.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenConfig {

    @Value("${api.security.token.secret")
    private String secret;

    public String generateToken(Usuario usuario){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withClaim("userId", usuario.getId())
                .withSubject(usuario.getEmail())
                .withClaim("role", usuario.getTipoUsuario().name())
                .withExpiresAt(Instant.now().plusSeconds(3600))//access token dura 1 hora, qnd acaba loga denovo
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

}
