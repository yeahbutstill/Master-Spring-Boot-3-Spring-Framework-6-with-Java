package com.yeahbutstill.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue
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

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @ToString.Exclude
    private List<Posting> postings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
