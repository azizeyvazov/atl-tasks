package com.classroom.spring_boot_task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {

    @NotBlank(message = "name can not be blank")
    @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)*$", message = "name must contain only letters and spaces.")
    private String name;

    @NotBlank(message = "name can not be blank")
    @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)*$", message = "surname must contain only letters and spaces.")
    private String surname;
}
