package br.com.fastfeetapp.app.controllers.exceptions;

import br.com.fastfeetapp.app.dtos.http.ExceptionDetailsErrorDto;
import br.com.fastfeetapp.app.dtos.http.StandardExceptionErrorDto;
import br.com.fastfeetapp.app.dtos.http.HttpResponseErrorDto;
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
    public ResponseEntity<HttpResponseErrorDto> entityAlreadyExists(HttpServletRequest request, ResourceAlreadyExists exception){
        ExceptionDetailsErrorDto exceptionDetails = makeExceptionDetailsErrorDto(exception.getMessage(), "Entity already exists!");
        StandardExceptionErrorDto standardExceptionErrorDto = makeStandarErorExceptionDto(request.getRequestURI(), HttpStatus.BAD_REQUEST.value());
        HttpResponseErrorDto response = new HttpResponseErrorDto(exceptionDetails, standardExceptionErrorDto);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(ResourceNotExistsException.class)
    public ResponseEntity<HttpResponseErrorDto> entityAlreadyExists(HttpServletRequest request, ResourceNotExistsException exception){
        ExceptionDetailsErrorDto exceptionDetails = makeExceptionDetailsErrorDto(exception.getMessage(), "Entity already exists!");
        StandardExceptionErrorDto standardExceptionErrorDto = makeStandarErorExceptionDto(request.getRequestURI(), HttpStatus.BAD_REQUEST.value());
        HttpResponseErrorDto response = new HttpResponseErrorDto(exceptionDetails, standardExceptionErrorDto);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    private static ExceptionDetailsErrorDto makeExceptionDetailsErrorDto (String exceptionMessage, String errorMessage){
        return ExceptionDetailsErrorDto.builder().exceptionMessage(exceptionMessage).errorMEssage(errorMessage).build();
    }

    private static StandardExceptionErrorDto makeStandarErorExceptionDto(String pathUrl, Integer status){
        return StandardExceptionErrorDto.builder().timestamp(Instant.now()).urlPath(pathUrl).status(status).build();
    }
}
