package com.yeahbutstill.entity;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class User {

    @NotNull
    @NotEmpty
    @NotBlank
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 6, max = 30)
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank
    @Past
    private LocalDate birthDate;

    public User() {
    }

    public User(Long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
