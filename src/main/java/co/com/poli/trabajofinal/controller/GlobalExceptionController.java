package co.com.poli.trabajofinal.controller;


import co.com.poli.trabajofinal.controller.exceptions.ResourceConflict;
import co.com.poli.trabajofinal.controller.exceptions.ResourceNotFoundException;
import co.com.poli.trabajofinal.utils.ResponseHttp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ResponseHttp handleCustomException(ResourceNotFoundException ex) {

        ResponseHttp responseHttp = new ResponseHttp();
        responseHttp.setCodeMessage(HttpStatus.NOT_FOUND.value());
        responseHttp.setMessageBody(ex.getMessage());
        responseHttp.setMessage("");

        return responseHttp;
    }

    @ExceptionHandler(ResourceConflict.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ResponseHttp handleConflictException(ResourceConflict ex) {

        ResponseHttp responseHttp = new ResponseHttp();
        responseHttp.setCodeMessage(HttpStatus.CONFLICT.value());
        responseHttp.setMessageBody(ex.getMessage());
        responseHttp.setMessage("");

        return responseHttp;
    }
}
