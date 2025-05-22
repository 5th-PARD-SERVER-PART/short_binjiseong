package com.pard.seminar6.user.entity;

import com.pard.seminar6.user.dto.UserReqDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Integer age;
    private String part;

    public void update(UserReqDto userReqDto) {
        if (userReqDto.getName() != null && !userReqDto.getName().trim().isEmpty()) {
            this.name = userReqDto.getName();
        }
        if (userReqDto.getAge() != null) {
            this.age = userReqDto.getAge();
        }
        if (userReqDto.getPart() != null && !userReqDto.getPart().trim().isEmpty()) {
            this.part = userReqDto.getPart();
        }
    }
}
