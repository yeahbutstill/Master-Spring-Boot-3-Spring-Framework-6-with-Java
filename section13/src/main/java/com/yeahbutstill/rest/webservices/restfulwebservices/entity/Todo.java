package com.yeahbutstill.rest.webservices.restfulwebservices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Todo {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank
	@NotEmpty
	private String username;

	@NotBlank
	@NotEmpty
	private String description;

	@NotNull
	private LocalDate targetDate;

	@NotNull
	private Boolean done;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Todo todo = (Todo) o;
		return id != null && Objects.equals(id, todo.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}