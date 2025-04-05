package com.pard.seminar3.user.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter

public class UserDto {
    private String email;
    private String password;
}
