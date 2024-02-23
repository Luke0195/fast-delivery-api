package br.com.fastfeetapp.app.dtos;

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
public class AddressRequestDto implements Serializable {

    private String name;
    private String complement;
    private String code;
    @JsonProperty("sub_locallity")
    private String sublocallity;
    private String state;
    private String city;
    private Integer number;
}
