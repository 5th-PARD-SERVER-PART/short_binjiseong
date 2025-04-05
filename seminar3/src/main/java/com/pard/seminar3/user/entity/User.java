package com.pard.seminar3.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class User {
    @Id//primary key로 꼭 필요함(중복되지 않음)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //아이디 생성방식 순서대로 알아서 넣을게
    private Long userId;//Id는 Long으로 하는게 정석

    @Column(name = "email", length =20) //@Column 넣으면 조건을 달 수 있음
    private String email;

    @Column(name = "password")
    private String password;

    @CreationTimestamp//db에 들어온 시간을 입력해줌(회원가입할 때 받아놓음)
    private Timestamp userSignUpTime;

    public void updateEmail(String email){
        this.email = email;
    }
    public void updatePassword(String password){
        this.email = password;
    }
}
