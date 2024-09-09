package com.classroom.spring_boot_task.service;

import com.classroom.spring_boot_task.dto.AuthorRequest;
import com.classroom.spring_boot_task.dto.AuthorResponse;

import java.util.List;

public interface AuthorService {

    void add(AuthorRequest authorRequest);

    AuthorResponse getById(Long id);

    List<AuthorResponse> getAll();

    void updateById(Long id, AuthorRequest authorRequest);

    void deleteById(Long id);
}
