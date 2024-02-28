package br.com.fastfeetapp.app.repositories;

import br.com.fastfeetapp.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserPostgresRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
