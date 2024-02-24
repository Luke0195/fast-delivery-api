package br.com.fastfeetapp.app.dtos;

import br.com.fastfeetapp.app.models.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipentRequestDto implements Serializable {
    @NotBlank(message = "The field name is required")
    private String name;
    private Address address;
}
