package br.com.fastfeetapp.app.repositories;

import br.com.fastfeetapp.app.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressPostgresRepository extends JpaRepository<Address, UUID> {
    Optional<Address> findByCode(String code);
}
