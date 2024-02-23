package br.com.fastfeetapp.app.mapper;

import br.com.fastfeetapp.app.dtos.AddressRequestDto;
import br.com.fastfeetapp.app.dtos.AddressResponseDto;
import br.com.fastfeetapp.app.models.Address;


public final class AddressMapper {

    private AddressMapper(){}
    public static Address mapAddressDtoToEntity(AddressRequestDto dto){
        return Address.builder()
                .name(dto.getName())
                .complement(dto.getComplement())
                .code(dto.getCode())
                .sublocallity(dto.getSublocallity())
                .state(dto.getState())
                .city(dto.getCity())
                .number(dto.getNumber())
                .build();
    }

    public static AddressResponseDto mapEntityToAddressResponseDto(Address entity){
        return AddressResponseDto.builder()
                .name(entity.getName())
                .complement(entity.getComplement())
                .code(entity.getCode())
                .sublocallity(entity.getSublocallity())
                .state(entity.getState())
                .city(entity.getCity())
                .number(entity.getNumber())
                .build();
    }
}
