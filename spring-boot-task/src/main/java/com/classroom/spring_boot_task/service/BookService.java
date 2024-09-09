package com.classroom.spring_boot_task.service;

import com.classroom.spring_boot_task.dto.BookRequest;
import com.classroom.spring_boot_task.dto.BookResponse;

import java.util.List;

public interface BookService {

    void addBook(BookRequest bookRequest);

    BookResponse getById(Long id);

    List<BookResponse> getAll();

    void updateBook(Long id, BookRequest bookRequest);

    void deleteBookById(Long id);
}
