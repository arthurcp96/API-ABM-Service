package com.ar.sportclubcafe.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

    public BadRequestException(String mensaje) {
        super(String.format("No se puede eliminar objeto inexistente",mensaje));
    }
    
}
