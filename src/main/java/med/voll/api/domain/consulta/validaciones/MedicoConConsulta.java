package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoConConsulta implements ValidadorDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DatosAgendarConsulta datosRegistroConsulta) {
        var idMedico = datosRegistroConsulta.idMedico();
        if (idMedico == null) {
            return;
        }

        var fecha = datosRegistroConsulta.fecha();
        var medico = consultaRepository.existsByMedicoIdAndFecha(idMedico, fecha);
        if (medico) {
            throw new ValidationException("El médico no está disponible en la fecha seleccionada");
        }
    }
}
