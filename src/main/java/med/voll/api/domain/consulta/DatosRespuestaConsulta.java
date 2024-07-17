package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuestaConsulta(Long id,
                                     Long idPaciente,
                                     Long idMedico,
                                     LocalDateTime fecha,
                                     String motivo) {

    public DatosRespuestaConsulta(Consulta consulta) {
        this(consulta.getId(),
                consulta.getPaciente().getId(),
                consulta.getMedico().getId(),
                consulta.getFecha(),
                consulta.getMotivoCancelacion() != null
                        ? consulta.getMotivoCancelacion().getDescripcion()
                        : "No cancelada");
    }
}
