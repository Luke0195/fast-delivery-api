package br.com.fastfeetapp.app.dtos;

import br.com.fastfeetapp.app.models.Address;
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

    public AddressRequestDto(Address entity){
        this.name = entity.getName();
        this.complement = entity.getComplement();
        this.code = entity.getCode();
        this.sublocallity = entity.getSublocallity();
        this.state = entity.getState();
        this.city = entity.getCity();
        this.number = entity.getNumber();
    }
}
