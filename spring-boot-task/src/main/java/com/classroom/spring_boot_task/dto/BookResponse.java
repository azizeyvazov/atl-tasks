package com.classroom.spring_boot_task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    String name;

    int count;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    Long authorId;
}
