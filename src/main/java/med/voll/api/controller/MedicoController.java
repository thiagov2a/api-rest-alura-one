package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaMedico> registrar(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico,
                                                          UriComponentsBuilder uriComponentsBuilder) {
        var medico = medicoRepository.save(new Medico(datosRegistroMedico));
        var url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosRespuestaMedico(medico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaMedico> actualizar(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        var medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
        return ResponseEntity.ok(new DatosRespuestaMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaMedico>> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {
        var pagina = medicoRepository.findByActivoTrue(paginacion)
                .map(DatosListaMedico::new);
        return ResponseEntity.ok(pagina);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.desactivar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaMedico> obtener(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaMedico(medico));
    }
}
