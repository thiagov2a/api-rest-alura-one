package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosActualizarMedico(@NotNull
                                    Long id,
                                    String nombre,
                                    @Pattern(regexp = "\\d{11}")
                                    String documento,
                                    DatosDireccion direccion) {
}
