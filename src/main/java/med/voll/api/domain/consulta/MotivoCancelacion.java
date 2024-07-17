package med.voll.api.domain.consulta;

public enum MotivoCancelacion {

    MEDICO_CANCELO("Médico canceló"),
    OTROS("Otros"),
    PACIENTE_CANCELO("Paciente canceló");

    private final String descripcion;

    MotivoCancelacion(String descripcion) {
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
