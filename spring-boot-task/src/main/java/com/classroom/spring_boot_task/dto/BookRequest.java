package com.classroom.spring_boot_task.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    @Pattern(regexp = "^[A-Za-z0-9\\s.,'!?-]+$", message = "Book title may only contain letters, numbers, spaces, and common punctuation marks.")
    @NotBlank(message = "name can not be blank")
    private String name;

    @Min(1)
    private int count;

    Long authorId;
}
