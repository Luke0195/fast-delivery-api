package br.com.fastfeetapp.app.repositories;

import br.com.fastfeetapp.app.models.Recipent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipentPostgresRepository extends JpaRepository<Recipent, UUID> {
}
