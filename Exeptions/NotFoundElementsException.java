package agencia.inmobiliaria.Exeptions;

public class NotFoundElementsException extends RuntimeException {
    public NotFoundElementsException(String message) {
        super(message);
    }
}