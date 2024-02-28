package br.com.fastfeetapp.app.services.impl;

import br.com.fastfeetapp.app.dtos.user.UserRequestDto;
import br.com.fastfeetapp.app.dtos.user.UserResponseDto;
import br.com.fastfeetapp.app.mapper.UserMapper;
import br.com.fastfeetapp.app.models.User;
import br.com.fastfeetapp.app.repositories.UserPostgresRepository;
import br.com.fastfeetapp.app.services.UserService;
import br.com.fastfeetapp.app.services.exceptions.ResourceAlreadyExists;
import br.com.fastfeetapp.app.utils.FileStorageProperties;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserPostgresRepository repository;

    private final Path finalStorageLocation;

    @Autowired
    public UserServiceImpl(UserPostgresRepository repository, FileStorageProperties fileStorageProperties) {
        this.repository = repository;
        this.finalStorageLocation = Paths.get(String.valueOf(fileStorageProperties.getUploadDir())).toAbsolutePath().normalize();
    }

    @Override
    @Transactional
    public UserResponseDto create(UserRequestDto dto) {
        Optional<User> userAlreadyExists = repository.findByEmail(dto.getEmail());
        if (userAlreadyExists.isPresent()) throw new ResourceAlreadyExists("This email is already taken!");
        User createdUser = mapRequestToEntity(dto);
        createdUser.setAvatarUrl(null);
        repository.save(createdUser);
        return mapEntityToDto(createdUser);
    }

    private static User mapRequestToEntity(UserRequestDto dto){
        return UserMapper.INSTANCE.mapUserRequestDtoToUser(dto);
    }

    private static UserResponseDto mapEntityToDto(User entity){
        return UserMapper.INSTANCE.mapUserRequestDtoToUser(entity);
    }

}
