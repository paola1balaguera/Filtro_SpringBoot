package agencia.inmobiliaria.Exeptions;

public class NombreInvalidoException extends RuntimeException {
    public NombreInvalidoException(String message) {
        super(message);
    }
}
