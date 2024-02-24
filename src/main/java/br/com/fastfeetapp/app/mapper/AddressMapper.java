package br.com.fastfeetapp.app.mapper;

import br.com.fastfeetapp.app.dtos.address.AddressRequestDto;
import br.com.fastfeetapp.app.dtos.address.AddressResponseDto;
import br.com.fastfeetapp.app.models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);


    @Mapping(target = "recipent", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Address mapAddressRequestDtoToEntity(AddressRequestDto requestDto);

    AddressResponseDto mapAddressEntityToDto(Address entity);

}
