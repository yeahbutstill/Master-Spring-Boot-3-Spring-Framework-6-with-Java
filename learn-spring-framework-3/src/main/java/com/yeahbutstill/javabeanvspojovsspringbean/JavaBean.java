package com.yeahbutstill.javabeanvspojovsspringbean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class JavaBean implements Serializable { // EJB

    private String text;
    private Integer number;

}
