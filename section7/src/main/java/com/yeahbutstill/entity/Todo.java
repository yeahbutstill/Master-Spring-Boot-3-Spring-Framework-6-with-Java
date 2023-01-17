package com.yeahbutstill.entity;

import jakarta.validation.constraints.NotNull;
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
    private String username;
    @Size(min = 6, max = 30, message = "Enter at least 6 chracter")
    @NotNull
    private String description;

    @NotNull
    private LocalDate targetDate;
    private Boolean done;

}
