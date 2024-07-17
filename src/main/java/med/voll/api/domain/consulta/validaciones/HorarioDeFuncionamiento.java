package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioDeFuncionamiento implements ValidadorDeConsultas {

    public void validar(DatosAgendarConsulta datosRegistroConsulta) {
        var fecha = datosRegistroConsulta.fecha();
        var domingo = DayOfWeek.SUNDAY.equals(fecha.getDayOfWeek());
        var antesDeApertura = fecha.getHour() < 7;
        var despuesDeCierre = fecha.getHour() > 19;

        if (domingo || antesDeApertura || despuesDeCierre) {
            throw new ValidationException("El horario de atención de la clínica es de lunes a sábado, de 07:00 a 19:00 horas");
        }
    }
}
