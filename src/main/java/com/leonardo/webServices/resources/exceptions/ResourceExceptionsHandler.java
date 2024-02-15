package com.leonardo.webServices.resources.exceptions;

import com.leonardo.webServices.service.exceptions.DatabaseException;
import com.leonardo.webServices.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import java.time.Instant;
@ControllerAdvice
public class ResourceExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound (ResourceNotFoundException e , HttpServletRequest request){
        String error = " Resource Not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError stndError = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(stndError);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> DatabaseIntegrid (DatabaseException e , HttpServletRequest request) {
        String error = " Data Base error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError stndError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(stndError);
    }

}
