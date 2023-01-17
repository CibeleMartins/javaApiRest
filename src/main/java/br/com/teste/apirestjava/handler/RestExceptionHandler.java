package br.com.teste.apirestjava.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.teste.apirestjava.model.error.ErrorMessage;
import br.com.teste.apirestjava.model.exception.ResourceNotFoundException;

// define ele como controlador na aplicacao
@ControllerAdvice 
public class RestExceptionHandler {
// uma classse para ser um controlador de qualquer erro em uma api rest
//  se o erro for do tipo ResourceNotFound chama o response entity

    // escuta a exceção passsada no parametro
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {

        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
}

