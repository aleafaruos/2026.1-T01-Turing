package br.com.seuespacounb.turing.config;

import br.com.seuespacounb.turing.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

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
    public Optional<JWTUserData> validateToken(String token){

        try {

            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT decode = JWT.require(algorithm)
                    .build().verify(token);

            return Optional.of(new JWTUserData(
                    decode.getClaim("userId").asLong(),
                    decode.getSubject(),
                    decode.getClaim("role").asString()
            ));

        }catch (JWTVerificationException ex){
            return Optional.empty();
        }
    }
}
