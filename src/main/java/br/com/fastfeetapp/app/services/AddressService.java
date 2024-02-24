package br.com.fastfeetapp.app.services;


import br.com.fastfeetapp.app.dtos.address.AddressRequestDto;
import br.com.fastfeetapp.app.dtos.address.AddressResponseDto;

public interface AddressService {

    AddressResponseDto createAddress(AddressRequestDto addressDto);
}
