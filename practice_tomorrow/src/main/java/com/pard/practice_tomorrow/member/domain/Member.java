package com.pard.practice_tomorrow.member.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Enumerated(EnumType.STRING)// 이걸 안해놓으면 숫자로 들어감, ADMIN =0,USER=1 이렇게 들어갈 수 있음
    @Builder.Default//Builder를 쓰면 알아서 유저로 만들어달라고 하는거
    private Role role = Role.USER;

    private String socialId;//구글에서 할당해주는 사용자 고유의 아이디, 안 바뀌기 때문에 세션에 박으면 아무것도 안해도 됨
    //애를 바로 pk로 써도 되긴 함
}
