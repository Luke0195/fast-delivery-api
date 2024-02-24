package br.com.fastfeetapp.app.repositories;

import br.com.fastfeetapp.app.models.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

@DataJpaTest
class AddressPostgresRepositoryTest {
    @Autowired
    private AddressPostgresRepository postgresRepository;


    @Test
    @DisplayName("Should create and adress when valid Data is provided")
    void saveShouldCreateAnAddressWhenValidDataIsProvided(){
        Address entity = Address
                .builder()
                .id(UUID.randomUUID())
                .name("Rua Sete Lagoas")
                .complement("Oficina")
                .code("31210470")
                .state("Minas Gerais")
                .city("Belo Horizonte")
                .number(93)
                .sublocallity("Bonfim")
                .build();
        entity = postgresRepository.save(entity);
        Assertions.assertNotNull(entity);
        Assertions.assertNotNull(entity.getId());
    }

}
