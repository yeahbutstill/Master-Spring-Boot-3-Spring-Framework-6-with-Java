package com.yeahbutstill.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Todo {

    private Long id;

    @NotBlank
    @NotEmpty
    private String username;

    @NotBlank
    @NotEmpty
    @Size(min = 8, max = 30, message = "Enter atleast 10 chracter")
    private String description;

    @NotBlank
    @NotEmpty
    private LocalDate targetDate;

    @NotBlank
    @NotEmpty
    private Boolean done;

}
