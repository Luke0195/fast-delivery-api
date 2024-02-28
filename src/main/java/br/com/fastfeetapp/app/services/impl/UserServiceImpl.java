package br.com.fastfeetapp.app.services.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserPostgresRepository repository;



    @Override
    @Transactional
    public UserResponseDto create(UserRequestDto dto) {
        Optional<User> userAlreadyExists = repository.findByEmail(dto.getEmail());
        if (userAlreadyExists.isPresent()) throw new ResourceAlreadyExists("This email is already taken!");
        String hashedPassword = hashedPassword(dto.getPassword());
        User createdUser = mapRequestToEntity(dto);
        createdUser.setPassword(hashedPassword);
        createdUser.setAvatarUrl(null);
        repository.save(createdUser);
        return mapEntityToDto(createdUser);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserResponseDto> findAllPaged(Pageable pageable) {
        Page<User> users = repository.findAll(pageable);
        return users.map(UserServiceImpl::mapEntityToDto);

    }

    private static User mapRequestToEntity(UserRequestDto dto){
        return UserMapper.INSTANCE.mapUserRequestDtoToUser(dto);
    }

    private static UserResponseDto mapEntityToDto(User entity){
        return UserMapper.INSTANCE.mapUserRequestDtoToUser(entity);
    }

    private String hashedPassword(String password){
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

}
