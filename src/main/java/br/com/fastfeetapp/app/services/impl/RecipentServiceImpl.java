package br.com.fastfeetapp.app.services.impl;

import br.com.fastfeetapp.app.dtos.recipent.RecipentRequestDto;
import br.com.fastfeetapp.app.dtos.recipent.RecipentResponseDto;
import br.com.fastfeetapp.app.mapper.RecipentMapper;
import br.com.fastfeetapp.app.models.Recipent;

import br.com.fastfeetapp.app.repositories.RecipentPostgresRepository;
import br.com.fastfeetapp.app.services.RecipentService;
import br.com.fastfeetapp.app.services.exceptions.ResourceNotExistsException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class RecipentServiceImpl implements RecipentService {

    private final RecipentPostgresRepository recipentRepository;

    @Override
    @Transactional
    public RecipentResponseDto create(RecipentRequestDto requestDto) {
        Recipent recipent = mapRecipentDtoToEntity(requestDto);
        recipentRepository.save(recipent);
        return mapRecipentEntityToDto(recipent);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RecipentResponseDto> findAll(Pageable pageable) {
        Page<Recipent> recipents = recipentRepository.findAll(pageable);
        return recipents.map(RecipentMapper.INSTANCE::mapEntityToRecipentRepsonseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public RecipentResponseDto findById(String id) {
        Optional<Recipent> recipentExists = recipentRepository.findById(UUID.fromString(id));
        if(recipentExists.isEmpty()) throw new ResourceNotExistsException("Entity not found");
        return mapRecipentEntityToDto(recipentExists.get());
    }

    @Override
    @Transactional(readOnly = true)
    public RecipentResponseDto update(String id, RecipentRequestDto requestDto) {
        Recipent recipent = recipentRepository.getReferenceById(UUID.fromString(id));
        if(Objects.isNull(recipent.getId())) throw new ResourceNotExistsException("Id not found");
        recipent =  mapRecipentDtoToEntity(requestDto);
        recipentRepository.save(recipent);
        return mapRecipentEntityToDto(recipent);


    }

    @Override
    public void deleteById(String id) {
       Optional<Recipent> recipentExists = recipentRepository.findById(UUID.fromString(id));
       Recipent recipent = recipentExists.orElseThrow(() -> new ResourceNotExistsException("Id not found"));
       recipentRepository.deleteById(recipent.getId());
    }

    private Recipent mapRecipentDtoToEntity(RecipentRequestDto dto){
        return RecipentMapper.INSTANCE.mapRecipentRequestDtoToEntity(dto);
    }

    private RecipentResponseDto mapRecipentEntityToDto(Recipent recipent){
        return RecipentMapper.INSTANCE.mapEntityToRecipentRepsonseDto(recipent);
    }
}
