package com.classroom.spring_boot_task.service;

import com.classroom.spring_boot_task.dto.BookRequest;
import com.classroom.spring_boot_task.dto.BookResponse;
import com.classroom.spring_boot_task.exception.BookNotFoundException;
import com.classroom.spring_boot_task.mapper.BookMapper;
import com.classroom.spring_boot_task.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository repository;

    private final BookMapper mapper;

    @Override
    @Transactional
    public void addBook(BookRequest bookRequest) {
        repository.save(mapper.dtoToEntity(bookRequest));
        log.info("Book is added");
    }

    @Override
    public BookResponse getById(Long id) {
        var book = repository.findById(id).orElseThrow(
                () -> new BookNotFoundException("Book not found with id " + id));
        return mapper.entityToDto(book);
    }

    @Override
    public List<BookResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateBook(Long id, BookRequest bookRequest) {
        var book = repository.findById(id).orElseThrow(
                () -> new BookNotFoundException("Book not found with id " + id));
        mapper.entityToDto(book);
        repository.save(book);
        log.info("Book is updated");
    }

    @Override
    @Transactional
    public void deleteBookById(Long id) {
        var book = repository.findById(id);
        if (book.isPresent()) repository.deleteById(id);
        else throw new BookNotFoundException("There is no a book with id " + id);
        log.info("Book is deleted");
    }
}
