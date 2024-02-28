package br.com.fastfeetapp.app.services;

import br.com.fastfeetapp.app.dtos.user.UserRequestDto;
import br.com.fastfeetapp.app.dtos.user.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {

    UserResponseDto create(UserRequestDto dto);
    Page<UserResponseDto> findAllPaged(Pageable pageable);

}
