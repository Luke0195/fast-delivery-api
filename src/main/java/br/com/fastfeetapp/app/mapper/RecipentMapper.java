package br.com.fastfeetapp.app.mapper;

import br.com.fastfeetapp.app.dtos.RecipentRequestDto;
import br.com.fastfeetapp.app.dtos.RecipentResponseDto;
import br.com.fastfeetapp.app.models.Recipent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipentMapper {
    RecipentMapper INSTANCE = Mappers.getMapper( RecipentMapper.class);

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    Recipent mapAddressRequestDtoToEntity(RecipentRequestDto requestDto);

    RecipentResponseDto mapEntityToRecipentAddressDto(Recipent entity);
}
