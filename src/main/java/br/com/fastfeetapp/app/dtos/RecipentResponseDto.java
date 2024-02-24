package br.com.fastfeetapp.app.dtos;

import br.com.fastfeetapp.app.models.Address;
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
public class RecipentResponseDto implements Serializable {

    private UUID id;
    private String name;
    private Address address;
}
