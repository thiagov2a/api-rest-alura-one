package med.voll.api.domain.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {

    private String calle;
    private String distrito;
    private String ciudad;
    private String numero;
    private String complemento;

    public Direccion(DatosDireccion datosDireccion) {
        this.calle = datosDireccion.calle();
        this.distrito = datosDireccion.distrito();
        this.ciudad = datosDireccion.ciudad();
        this.numero = datosDireccion.numero();
        this.complemento = datosDireccion.complemento();
    }

    public Direccion actualizarDatos(DatosDireccion direccion) {
        return new Direccion(direccion);
    }
}
