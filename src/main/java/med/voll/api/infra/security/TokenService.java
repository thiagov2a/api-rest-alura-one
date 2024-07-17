package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import med.voll.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String secretKey;

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withIssuer("voll_med")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(getExpiration())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException(e);
        }
    }

    public Instant getExpiration() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException("El token es inválido");
        }

        DecodedJWT verifier;

        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            verifier = JWT.require(algorithm)
                    .withIssuer("voll_med")
                    .build()
                    .verify(token);
        } catch (JWTCreationException e) {
            throw new RuntimeException(e);
        }

        if (verifier == null) {
            throw new RuntimeException("El token es inválido");
        }

        return verifier.getSubject();
    }

}
