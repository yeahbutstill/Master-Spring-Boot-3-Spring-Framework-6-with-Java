package com.yeahbutstill.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Course {

    private Long id;
    private String name;
    private String author;

}
