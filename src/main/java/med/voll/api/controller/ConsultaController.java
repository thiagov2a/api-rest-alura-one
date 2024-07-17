package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consulta.ConsultaService;
import med.voll.api.domain.consulta.DatosCancelarConsulta;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.consulta.DatosRespuestaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaConsulta> agendar(@RequestBody @Valid DatosAgendarConsulta datosRegistroConsulta) {
        var respuesta = consultaService.agendar(datosRegistroConsulta);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaConsulta>> listar(@PageableDefault(size = 10, sort = {"fecha"}) Pageable paginacion) {
        var pagina = consultaService.listar(paginacion);
        return ResponseEntity.ok(pagina);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<?> cancelar(@RequestBody @Valid DatosCancelarConsulta datosCancelarConsulta) {
        consultaService.cancelar(datosCancelarConsulta);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaConsulta> obtener(@PathVariable Long id) {
        var consulta = consultaService.obtener(id);
        return ResponseEntity.ok(consulta);
    }
}
