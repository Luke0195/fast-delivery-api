package br.com.fastfeetapp.app.dtos.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpResponseErrorDto implements Serializable {
    private ExceptionDetailsErrorDto exceptionDetailsErrorDto;
    private StandardExceptionErrorDto standardExceptionErrorDto;
}
