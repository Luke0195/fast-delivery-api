package br.com.fastfeetapp.app.controllers.exceptions;

import br.com.fastfeetapp.app.dtos.ResponseErrorDto;
import br.com.fastfeetapp.app.services.exceptions.ResourceAlreadyExists;
import br.com.fastfeetapp.app.services.exceptions.ResourceNotExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ResponseErrorDto> entityAlreadyExists(HttpServletRequest request, ResourceAlreadyExists exception){
        ResponseErrorDto response = ResponseErrorDto
                .builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .errorMessage("Entity already exists!")
                .exceptionMessage(exception.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(ResourceNotExistsException.class)
    public ResponseEntity<ResponseErrorDto> entityAlreadyExists(HttpServletRequest request, ResourceNotExistsException exception){
        ResponseErrorDto response = ResponseErrorDto
                .builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .errorMessage("Entity not found!")
                .exceptionMessage(exception.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
