package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuario.DatosAutentificacionUsuario;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.infra.security.DatosJWTToken;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/login")
@Tag(name = "Autentificación", description = "API para la autenticación de usuarios")
public class AutentificacionController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Operation(summary = "Autenticación de usuario",
            description = "Autentica un usuario y devuelve un token JWT.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Token JWT generado exitosamente"),
                    @ApiResponse(responseCode = "403", description = "Credenciales inválidas")
            })
    public ResponseEntity<DatosJWTToken> autentificar(
            @RequestBody @Valid
            @Parameter(description = "Datos de autenticación del usuario")
            DatosAutentificacionUsuario datosAutentificacionUsuario) {
        var authToken = new UsernamePasswordAuthenticationToken(
                datosAutentificacionUsuario.login(),
                datosAutentificacionUsuario.password());
        var authUser = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) authUser.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}
