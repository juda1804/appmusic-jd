package co.com.poli.trabajofinal.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceConflict extends RuntimeException {
    public ResourceConflict() {
        super();
    }
    public ResourceConflict(String message, Throwable cause) {
        super(message, cause);
    }
    public ResourceConflict(String message) {
        super(message);
    }
    public ResourceConflict(Throwable cause) {
        super(cause);
    }
}