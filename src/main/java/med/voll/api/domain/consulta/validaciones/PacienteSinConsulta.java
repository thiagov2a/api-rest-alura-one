package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteSinConsulta implements ValidadorDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DatosAgendarConsulta datosRegistroConsulta) {
        var idPaciente = datosRegistroConsulta.idPaciente();
        var fecha = datosRegistroConsulta.fecha();
        var primerHorario = fecha.withHour(7);
        var ultimoHorario = fecha.withHour(18);

        var pacienteConConsulta = consultaRepository.existsByPacienteIdAndFechaBetween(idPaciente, primerHorario, ultimoHorario);
        if (pacienteConConsulta) {
            throw new ValidationException("El paciente ya tiene una consulta para ese día");
        }
    }
}
