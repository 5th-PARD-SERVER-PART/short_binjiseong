package com.pard.hw3.book.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Book {
    //primary key가 무조건 있어야 함
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "bookId", length= 30)
    private Long bookId;

    @Column(name = "bookName", length= 30)
    private String bookName;

    @Column(name = "author", length= 30)
    private String author;

    @Column(name = "publisher", length= 20)
    private String publisher;

    @Column(name = "year", length= 5)
    private long year;

    @CreationTimestamp
    private Timestamp bookSignUpTime;

}
