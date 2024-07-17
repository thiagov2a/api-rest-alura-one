package med.voll.api.domain.medico;

import java.text.Normalizer;
import java.util.regex.Pattern;

public enum Especialidad {

    CARDIOLOGIA("Cardiología"),
    GINECOLOGIA("Ginecología"),
    ORTOPEDIA("Ortopedia"),
    PEDIATRIA("Pediatría");

    private final String descripcion;

    Especialidad(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
