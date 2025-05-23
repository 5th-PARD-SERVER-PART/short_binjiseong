package com.pard.practice_tomorrow.user.entity;


import com.pard.practice_tomorrow.post.entity.Post;
import com.pard.practice_tomorrow.user.dto.UserReqDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;

    public void update(UserReqDto.UserCreateUpdate req) {
        if (req.getUserName() != null && !req.getUserName().trim().isEmpty()){// string
            this.userName = req.getUserName();
        }
//        if (userReqDto.getAge() != null) { //숫자
//            this.age = userReqDto.getAge();
//        }
//        }
    }
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;
}
