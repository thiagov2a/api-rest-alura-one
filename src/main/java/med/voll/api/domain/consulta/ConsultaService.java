package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validaciones.ValidadorDeConsultas;
import med.voll.api.domain.consulta.validaciones.cancelar.ValidadorCancelarDeConsultas;
import med.voll.api.domain.medico.Especialidad;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.errors.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private List<ValidadorDeConsultas> validadoresDeConsulta;
    @Autowired
    private List<ValidadorCancelarDeConsultas> validadoresEliminarDeConsultas;

    public DatosRespuestaConsulta agendar(DatosAgendarConsulta datosRegistroConsulta) {
        var pacienteOptional = pacienteRepository.findById(datosRegistroConsulta.idPaciente());
        if (pacienteOptional.isEmpty()) {
            throw new ValidacionDeIntegridad("Paciente no encontrado");
        }
        var paciente = pacienteOptional.get();

        Medico medico;
        if (datosRegistroConsulta.idMedico() != null) {
            var medicoOptional = medicoRepository.findById(datosRegistroConsulta.idMedico());
            if (medicoOptional.isEmpty()) {
                throw new ValidacionDeIntegridad("Médico no encontrado");
            }
            medico = medicoOptional.get();
        } else {
            medico = medicoDisponible(datosRegistroConsulta);
            if (medico == null) {
                throw new ValidacionDeIntegridad("No se encontró un médico disponible para la especialidad y fecha proporcionadas");
            }
        }

        validadoresDeConsulta.forEach(v -> v.validar(datosRegistroConsulta));

        var consulta = new Consulta(null,
                medico,
                paciente,
                datosRegistroConsulta.fecha(),
                null);

        consultaRepository.save(consulta);

        return new DatosRespuestaConsulta(consulta);
    }

    public Medico medicoDisponible(DatosAgendarConsulta datosRegistroConsulta) {
        var especialidad = datosRegistroConsulta.especialidad();
        if (especialidad == null) {
            throw new ValidacionDeIntegridad("Especialidad no proporcionada");
        }

        if (datosRegistroConsulta.fecha() == null) {
            throw new ValidacionDeIntegridad("Fecha no proporcionada");
        }

        return medicoRepository.buscarMedicoPorFechaYEspecialidad(datosRegistroConsulta.fecha(), especialidad);
    }

    public Page<DatosRespuestaConsulta> listar(Pageable paginacion) {
        return consultaRepository.findByMotivoCancelacionIsNull(paginacion)
                .map(DatosRespuestaConsulta::new);
    }

    public void cancelar(DatosCancelarConsulta datosEliminarConsulta) {
        var idConsulta = datosEliminarConsulta.idConsulta();
        var consultaEsta = consultaRepository.existsById(idConsulta);
        if (!consultaEsta) {
            throw new ValidacionDeIntegridad("Consulta no encontrada");
        }

        validadoresEliminarDeConsultas.forEach(v -> v.validar(datosEliminarConsulta));

        var consulta = consultaRepository.getReferenceById(idConsulta);
        consulta.cancelar(datosEliminarConsulta.motivo());
    }

    public DatosRespuestaConsulta obtener(Long id) {
        var consulta = consultaRepository.getReferenceById(id);
        return new DatosRespuestaConsulta(consulta);
    }
}
