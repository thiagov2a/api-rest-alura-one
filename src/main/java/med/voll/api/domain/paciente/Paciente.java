package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Embedded
    private Direccion direccion;

    public Paciente(DatosRegistroPaciente datosRegistroPaciente) {
        this.activo = true;
        this.nombre = datosRegistroPaciente.nombre();
        this.email = datosRegistroPaciente.email();
        this.telefono = datosRegistroPaciente.telefono();
        this.documento = datosRegistroPaciente.documento();
        this.direccion = new Direccion(datosRegistroPaciente.direccion());
    }

    public void actualizarDatos(DatosActualizarPaciente datosActualizarPaciente) {
        if (datosActualizarPaciente.nombre() != null) {
            this.nombre = datosActualizarPaciente.nombre();
        }
        if (datosActualizarPaciente.telefono() != null) {
            this.telefono = datosActualizarPaciente.telefono();
        }
        if (datosActualizarPaciente.direccion() != null) {
            this.direccion = direccion.actualizarDatos(datosActualizarPaciente.direccion());
        }
    }

    public void desactivar() {
        this.activo = false;
    }
}