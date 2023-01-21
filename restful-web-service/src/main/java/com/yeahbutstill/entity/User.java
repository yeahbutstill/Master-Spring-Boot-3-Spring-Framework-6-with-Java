package com.yeahbutstill.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 30, message = "Name should have at least 3 characters")
    @JsonProperty("user_name")
    private String name;

    @NotNull
    @PastOrPresent(message = "Birth Date should be in the past or present")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

}
