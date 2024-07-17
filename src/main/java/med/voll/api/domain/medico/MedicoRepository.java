package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findByActivoTrue(Pageable paginacion);

    @Query("SELECT m FROM Medico m " +
           "WHERE m.activo = true AND " +
           "(:especialidad IS NULL OR m.especialidad = :especialidad) AND " +
           "m.id NOT IN (SELECT c.medico.id FROM Consulta c WHERE c.fecha = :fecha)" +
           "ORDER BY RAND()" +
           "LIMIT 1")
    Medico buscarMedicoPorFechaYEspecialidad(LocalDateTime fecha, Especialidad especialidad);

    @Query("SELECT m.activo FROM Medico m WHERE m.id =:idMedico")
    Boolean estaActivoPorId(Long idMedico);
}
