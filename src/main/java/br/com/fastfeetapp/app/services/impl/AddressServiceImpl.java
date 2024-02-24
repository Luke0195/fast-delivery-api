package br.com.fastfeetapp.app.services.impl;



import br.com.fastfeetapp.app.dtos.address.AddressRequestDto;
import br.com.fastfeetapp.app.dtos.address.AddressResponseDto;
import br.com.fastfeetapp.app.mapper.AddressMapper;
import br.com.fastfeetapp.app.models.Address;
import br.com.fastfeetapp.app.repositories.AddressPostgresRepository;
import br.com.fastfeetapp.app.services.AddressService;
import br.com.fastfeetapp.app.services.exceptions.ResourceAlreadyExists;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;


@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final  AddressPostgresRepository addressRepository;

    @Override
    @Transactional
    public AddressResponseDto createAddress(AddressRequestDto requestDto) {
        Optional<Address> addressAlreadyExists = addressRepository.findByCode(requestDto.getCode());
        if(addressAlreadyExists.isPresent()) throw new ResourceAlreadyExists("Address code already exists");
        Address createdAddress = AddressMapper.INSTANCE.mapAddressRequestDtoToEntity(requestDto);
        addressRepository.save(createdAddress);
        return AddressMapper.INSTANCE.mapAddressEntityToDto(createdAddress);
    }


}
