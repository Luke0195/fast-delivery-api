package br.com.fastfeetapp.app.mapper;

import br.com.fastfeetapp.app.dtos.recipent.RecipentRequestDto;
import br.com.fastfeetapp.app.dtos.recipent.RecipentResponseDto;
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
    Recipent mapRecipentRequestDtoToEntity(RecipentRequestDto requestDto);

    @Mapping(target="address.id", source="address.id")
    RecipentResponseDto mapEntityToRecipentRepsonseDto(Recipent entity);
}
