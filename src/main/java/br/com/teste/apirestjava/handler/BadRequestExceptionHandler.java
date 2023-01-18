package br.com.teste.apirestjava.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.teste.apirestjava.model.error.ErrorMessage;
import br.com.teste.apirestjava.model.exception.ResourceBadRequestException;

@ControllerAdvice
public class BadRequestExceptionHandler {
    
    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<?> BadRequestResponse(ResourceBadRequestException ex) {
        
        ErrorMessage error = new ErrorMessage("Bad Request", HttpStatus.BAD_REQUEST.value(), ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
