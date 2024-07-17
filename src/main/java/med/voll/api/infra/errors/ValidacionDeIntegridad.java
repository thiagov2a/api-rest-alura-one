package med.voll.api.infra.errors;

public class ValidacionDeIntegridad extends RuntimeException {

    public ValidacionDeIntegridad(String message) {
        super(message);
    }

}
