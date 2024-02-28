package br.com.fastfeetapp.app.controllers;

import br.com.fastfeetapp.app.dtos.user.UserRequestDto;
import br.com.fastfeetapp.app.dtos.user.UserResponseDto;

import br.com.fastfeetapp.app.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserServiceImpl userServiceImpl;


    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<UserResponseDto> createUser(@Valid @ModelAttribute UserRequestDto userRequestDto) {
        UserResponseDto dto = userServiceImpl.create(userRequestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
