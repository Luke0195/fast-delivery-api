package br.com.fastfeetapp.app.services.impl;

import br.com.fastfeetapp.app.dtos.recipent.RecipentRequestDto;
import br.com.fastfeetapp.app.dtos.recipent.RecipentResponseDto;
import br.com.fastfeetapp.app.mapper.RecipentMapper;
import br.com.fastfeetapp.app.models.Recipent;

import br.com.fastfeetapp.app.repositories.RecipentPostgresRepository;
import br.com.fastfeetapp.app.services.RecipentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@AllArgsConstructor
public class RecipentServiceImpl implements RecipentService {

    private final RecipentPostgresRepository recipentRepository;

    @Override
    @Transactional
    public RecipentResponseDto create(RecipentRequestDto requestDto) {
        Recipent recipent = RecipentMapper.INSTANCE.mapAddressRequestDtoToEntity(requestDto);
        recipentRepository.save(recipent);
        return RecipentMapper.INSTANCE.mapEntityToRecipentAddressDto(recipent);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RecipentResponseDto> findAll(Pageable pageable) {
        Page<Recipent> recipents = recipentRepository.findAll(pageable);
        return recipents.map(RecipentMapper.INSTANCE::mapEntityToRecipentAddressDto);
    }

    @Override
    public RecipentResponseDto findById(String id) {
        return null;
    }

    @Override
    public RecipentResponseDto update(String id, RecipentRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
