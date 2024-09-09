package com.classroom.spring_boot_task.controller;

import com.classroom.spring_boot_task.dto.AuthorRequest;
import com.classroom.spring_boot_task.dto.AuthorResponse;
import com.classroom.spring_boot_task.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/authors/")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public void addAuthor(@RequestBody @Valid AuthorRequest authorRequest){
        authorService.add(authorRequest);
    }

    @GetMapping("/{id}")
    public AuthorResponse getAuthorById(@PathVariable Long id){
        return authorService.getById(id);
    }

    @GetMapping
    public List<AuthorResponse> getAllAuthors(){
        return authorService.getAll();
    }

    @PutMapping
    public void updateAuthor(@RequestParam Long id, @RequestBody @Valid AuthorRequest authorRequest){
        authorService.updateById(id, authorRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.deleteById(id);
    }
}
