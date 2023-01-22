package com.yeahbutstill.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;

}
