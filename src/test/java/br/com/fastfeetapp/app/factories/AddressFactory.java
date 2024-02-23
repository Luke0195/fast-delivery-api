package br.com.fastfeetapp.app.factories;

import br.com.fastfeetapp.app.dtos.AddressRequestDto;
import br.com.fastfeetapp.app.mapper.AddressMapper;
import br.com.fastfeetapp.app.models.Address;

import java.util.UUID;

public final class AddressFactory {

    private AddressFactory(){};


    public static Address makeAddress(){
        return Address
                .builder()
                .id(UUID.randomUUID())
                .name("Rua Sete Lagoas")
                .complement("Oficina")
                .code("31210470")
                .state("Minas Gerais")
                .city("Belo Horizonte")
                .number(93)
                .sublocallity("Bonfim")
                .build();
    }

    public static AddressRequestDto makeAddressRequestDto(){
        Address address = makeAddress();
        address.setId(null);
        return new AddressRequestDto(address);
    }
}
