package com.pard.hw5.likes.entity;

import com.pard.hw5.post.entity.Post;
import com.pard.hw5.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    private boolean liked;

    public Likes(User user,Post post,boolean liked){
        this.user = user;
        this.post = post;
        this.liked = liked;
    }

    public void toggle(){
        this.liked = !this.liked;
    }

}
