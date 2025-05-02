package com.pard.hw4.post.entity;

import com.pard.hw4.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;
    @CreationTimestamp
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Post from(String title,String content,Timestamp date,User user){
        return new Post(null, title,content,date,user);
    }
    public void updateContent(String content){
        this.content = content;
    }
    public void updateTitle(String title){
        this.title = title;
    }
}
