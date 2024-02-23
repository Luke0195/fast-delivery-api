package br.com.fastfeetapp.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseErrorDto implements Serializable {

    private Instant timestamp;
    private Integer status;
    @JsonProperty("error_message")
    private String errorMessage;
    @JsonProperty("exception_message")
    private String exceptionMessage;
    @JsonProperty("url_path")
    private String path;
}
