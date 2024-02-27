package br.com.fastfeetapp.app.dtos.http;

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
public class StandardExceptionErrorDto implements Serializable {

    private Instant timestamp;
    @JsonProperty("url_path")
    private String urlPath;
    private Integer status;

}
