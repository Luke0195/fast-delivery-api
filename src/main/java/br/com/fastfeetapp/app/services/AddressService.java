package br.com.fastfeetapp.app.services;


import br.com.fastfeetapp.app.dtos.AddressRequestDto;
import br.com.fastfeetapp.app.dtos.AddressResponseDto;

public interface AddressService {

    AddressResponseDto createAddress(AddressRequestDto addressDto);
}
