package com.pard.seminar6.user.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class UserResDto {
    private int id;
    private String name;
    private Integer age;
    private String part;
}
