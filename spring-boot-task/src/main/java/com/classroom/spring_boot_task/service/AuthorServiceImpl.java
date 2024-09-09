package com.classroom.spring_boot_task.service;

import com.classroom.spring_boot_task.dto.AuthorRequest;
import com.classroom.spring_boot_task.dto.AuthorResponse;
import com.classroom.spring_boot_task.exception.AuthorNotFoundException;
import com.classroom.spring_boot_task.mapper.AuthorMapper;
import com.classroom.spring_boot_task.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository repository;

    private final AuthorMapper mapper;

    @Override
    @Transactional
    public void add(AuthorRequest authorRequest) {
        repository.save(mapper.dtoToEntity(authorRequest));
        log.info("Author added");
    }

    @Override
    public AuthorResponse getById(Long id) {
        var author = repository.findById(id).orElseThrow(
                () -> new AuthorNotFoundException("Author not found with id " + id));
        return mapper.entityToDto(author);
    }

    @Override
    public List<AuthorResponse> getAll() {
        var authors = repository.findAll();
        if (authors.isEmpty()) log.info("There aren't any authors");
        return authors.stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateById(Long id, AuthorRequest authorRequest) {
        var author = repository.findById(id).orElseThrow(
                () -> new AuthorNotFoundException("Author not found with id " + id));
        mapper.updateAuthor(authorRequest, author);
        repository.save(author);
        log.info("Author is updated");
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        var author = repository.findById(id);
        if (author.isPresent()) repository.deleteById(id);
        else throw new AuthorNotFoundException("Author not found with id " + id);
        log.info("Author is deleted ");
    }
}
