package com.yeahbutstill.bean;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;

}
