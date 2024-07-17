package med.voll.api.domain.consulta.validaciones.cancelar;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosCancelarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioDeAntecedencia implements ValidadorCancelarDeConsultas {

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DatosCancelarConsulta datos) {
        var consulta = repository.getReferenceById(datos.idConsulta());
        var ahora = LocalDateTime.now();
        var diferenciaEnHoras = Duration.between(ahora, consulta.getFecha()).toHours();

        if (diferenciaEnHoras < 24) {
            throw new ValidationException("Las consultas solo pueden ser canceladas con 24hs de antecedencia");
        }
    }
}

