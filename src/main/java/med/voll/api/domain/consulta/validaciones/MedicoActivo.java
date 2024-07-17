package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoActivo implements ValidadorDeConsultas {

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DatosAgendarConsulta datosRegistroConsulta) {
        var idMedico = datosRegistroConsulta.idMedico();
        if (idMedico == null) {
            return;
        }

        var medicoActivo = medicoRepository.estaActivoPorId(idMedico);
        if (!medicoActivo) {
            throw new ValidationException("No se pueden registrar consultas de médicos inactivos");
        }
    }
}
