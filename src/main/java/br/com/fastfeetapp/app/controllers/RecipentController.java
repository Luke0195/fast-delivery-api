package br.com.fastfeetapp.app.controllers;

import br.com.fastfeetapp.app.dtos.recipent.RecipentRequestDto;
import br.com.fastfeetapp.app.dtos.recipent.RecipentResponseDto;
import br.com.fastfeetapp.app.services.impl.RecipentServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@AllArgsConstructor
@RestController
@RequestMapping(value="/recipents")
public class RecipentController {
    private final RecipentServiceImpl recipentServiceImpl;
    @PostMapping
    public ResponseEntity<RecipentResponseDto> createRecipent(@Valid @RequestBody RecipentRequestDto dto){
        RecipentResponseDto response = recipentServiceImpl.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<RecipentResponseDto>> findAllRecipentsPaged(Pageable pageable){
        Page<RecipentResponseDto> findAllRecipents = recipentServiceImpl.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(findAllRecipents);
    }
}
