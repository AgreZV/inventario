package cl.control.inventario.exception;

public class ModeloNotFoundException extends RuntimeException{
    public ModeloNotFoundException(String message) {
        super(message);
    }
}
