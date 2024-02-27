package br.com.fastfeetapp.app.dtos.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionDetailsErrorDto implements Serializable {

    @JsonProperty("exception_message")
    private String exceptionMessage;
    @JsonProperty("error_message")
    private String errorMEssage;
}
