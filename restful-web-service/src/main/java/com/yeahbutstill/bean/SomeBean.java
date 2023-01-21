package com.yeahbutstill.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class SomeBean {

    private String field1;

    @JsonIgnore
    private String field2;
    private String field3;
    private String field4;
    private String field5;

}
