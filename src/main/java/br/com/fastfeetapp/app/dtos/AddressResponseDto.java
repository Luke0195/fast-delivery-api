package br.com.fastfeetapp.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponseDto  implements Serializable {

    private UUID id;
    private String name;
    private String complement;
    private String code;
    @JsonProperty("sub_locallity")
    private String sublocallity;
    private String state;
    private String city;
    private Integer number;

}
