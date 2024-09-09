package com.classroom.spring_boot_task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {

    String name;

    String surname;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
