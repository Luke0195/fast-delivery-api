package br.com.fastfeetapp.app.services.impl;



import br.com.fastfeetapp.app.dtos.AddressRequestDto;
import br.com.fastfeetapp.app.dtos.AddressResponseDto;
import br.com.fastfeetapp.app.mapper.AddressMapper;
import br.com.fastfeetapp.app.models.Address;
import br.com.fastfeetapp.app.repositories.AddressPostgresRepository;
import br.com.fastfeetapp.app.services.AddressService;
import br.com.fastfeetapp.app.services.exceptions.ResourceAlreadyExists;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;


@Service

public class AddressServiceImpl implements AddressService {

    @Autowired
    private  AddressPostgresRepository addressRepository;

    @Override
    @Transactional
    public AddressResponseDto createAddress(AddressRequestDto requestDto) {
        O
        Address createdAddress = AddressMapper.mapAddressDtoToEntity(requestDto);
        addressRepository.save(createdAddress);
        return AddressMapper.mapEntityToAddressResponseDto(createdAddress);
    }


}
