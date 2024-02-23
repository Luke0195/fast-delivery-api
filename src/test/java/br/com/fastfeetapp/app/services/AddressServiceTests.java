package br.com.fastfeetapp.app.services;

import br.com.fastfeetapp.app.dtos.AddressRequestDto;
import br.com.fastfeetapp.app.dtos.AddressResponseDto;
import br.com.fastfeetapp.app.factories.AddressFactory;
import br.com.fastfeetapp.app.repositories.AddressPostgresRepository;
import br.com.fastfeetapp.app.services.exceptions.ResourceAlreadyExists;
import br.com.fastfeetapp.app.services.impl.AddressServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
 class AddressServiceTests {

    @InjectMocks
    private AddressServiceImpl addressService;
    @Mock
    private AddressPostgresRepository addressPostgresRepository;

    private String existingCode;


    @BeforeEach
    void setup() throws Exception{
        this.existingCode = "31210470";


    }


    @Test
    @DisplayName("Save should create an address when valid data is provided")
    void createAddressShouldReturnAnResponseDtoWhenValidDataIsProvided(){
        AddressRequestDto addressRequest = AddressFactory.makeAddressRequestDto();
        AddressResponseDto response =  addressService.createAddress(addressRequest);
        Assertions.assertNotNull(response);
    }



}
