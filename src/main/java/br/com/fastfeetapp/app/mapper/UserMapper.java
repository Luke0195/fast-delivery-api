package br.com.fastfeetapp.app.mapper;


import br.com.fastfeetapp.app.dtos.user.UserRequestDto;
import br.com.fastfeetapp.app.dtos.user.UserResponseDto;
import br.com.fastfeetapp.app.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target="avatarUrl", ignore = true)
    User mapUserRequestDtoToUser(UserRequestDto dto);

    @Mapping(target="avatarUrl", ignore = true)
    UserResponseDto mapUserRequestDtoToUser(User entity);

}
