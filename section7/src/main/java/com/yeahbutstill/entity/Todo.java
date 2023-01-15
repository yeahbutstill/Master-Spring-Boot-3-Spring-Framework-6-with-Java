package com.yeahbutstill.entity;

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
    private String description;
    private LocalDate targetDate;
    private Boolean done;

}
