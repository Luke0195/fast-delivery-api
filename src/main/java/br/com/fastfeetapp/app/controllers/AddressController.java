package br.com.fastfeetapp.app.controllers;

import br.com.fastfeetapp.app.dtos.AddressRequestDto;
import br.com.fastfeetapp.app.dtos.AddressResponseDto;

import br.com.fastfeetapp.app.services.impl.AddressServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.net.URI;
@AllArgsConstructor
@RestController
@RequestMapping(value = "/address")
public class AddressController {

    private AddressServiceImpl addressServiceImpl;
    @PostMapping
    public ResponseEntity<AddressResponseDto> createAddress(@Valid @RequestBody AddressRequestDto dto){
        AddressResponseDto response = addressServiceImpl.createAddress(dto);
        return ResponseEntity.status(201).body(response);
    }


}
