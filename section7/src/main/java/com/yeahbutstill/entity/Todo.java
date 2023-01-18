package com.yeahbutstill.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

// JPA
// Bean -> Database

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity // This mapping bean to database table
public class Todo {

    // Primary Key
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    @Size(min = 6, max = 30, message = "Enter at least 6 character")
    @NotNull
    private String description;

    @NotNull
    private LocalDate targetDate;
    private Boolean done;

}
