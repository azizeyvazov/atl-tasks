package com.classroom.spring_boot_task.controller;

import com.classroom.spring_boot_task.dto.BookRequest;
import com.classroom.spring_boot_task.dto.BookResponse;
import com.classroom.spring_boot_task.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/books/")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public void addBook(@RequestBody @Valid BookRequest bookRequest) {
        bookService.addBook(bookRequest);
    }

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PutMapping
    public void updateBook(@RequestParam Long id, @RequestBody @Valid BookRequest bookRequest) {
        bookService.updateBook(id, bookRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
