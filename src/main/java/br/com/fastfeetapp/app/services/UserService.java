package br.com.fastfeetapp.app.services;

import br.com.fastfeetapp.app.dtos.user.UserRequestDto;
import br.com.fastfeetapp.app.dtos.user.UserResponseDto;

public interface UserService {

    UserResponseDto create(UserRequestDto dto);
}
