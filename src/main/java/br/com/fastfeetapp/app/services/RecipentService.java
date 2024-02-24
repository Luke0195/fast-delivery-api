package br.com.fastfeetapp.app.services;

import br.com.fastfeetapp.app.dtos.RecipentRequestDto;
import br.com.fastfeetapp.app.dtos.RecipentResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface RecipentService {

    RecipentResponseDto create(RecipentRequestDto requestDto);
    Page<RecipentResponseDto> findAllPaged(Pageable pageable);
    RecipentResponseDto findById(String id);

    RecipentResponseDto update(String id, RecipentRequestDto requestDto);

    void deleteById(String id);

}
