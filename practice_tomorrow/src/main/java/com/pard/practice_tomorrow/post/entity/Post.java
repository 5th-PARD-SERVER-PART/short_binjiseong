package com.pard.practice_tomorrow.post.entity;

import com.pard.practice_tomorrow.post.dto.PostReqDto;
import com.pard.practice_tomorrow.user.dto.UserReqDto;
import com.pard.practice_tomorrow.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name ="userId")
    private User user;

    // from을 사용하는 이유
    //Post post = new Post(null, title, content, date, user); // → 매개변수가 뭔지 파악 어려움
    //Post post = Post.from(title, content, date, user); // → "데이터로부터 Post를 만든다"
    //근데 그냥 builder로 해도 됨. -> 난 이걸로 할래~

//    public static Post from(String title, String content, User user) {
//        return new Post(null, title, content, user);
//    }
    public void update(PostReqDto.PostCreateUpdate req) {
        if (req.getTitle() != null && !req.getTitle().trim().isEmpty()){// string
            this.title = req.getTitle();
        }
        if (req.getContent() != null && !req.getContent().trim().isEmpty()){// string
            this.content = req.getContent();
        }
    //        if (userReqDto.getAge() != null) { //숫자
    //            this.age = userReqDto.getAge();
    //        }
    //        }
    }

}
