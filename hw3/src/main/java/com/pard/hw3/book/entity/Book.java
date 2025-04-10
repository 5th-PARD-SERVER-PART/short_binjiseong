package com.pard.hw3.book.entity;

import com.pard.hw3.book.dto.RequestBookDto;
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

    public void update(RequestBookDto requestBookDto) {
        if (requestBookDto.getBookId() != null) {
            this.bookId = requestBookDto.getBookId();
        }
        if (requestBookDto.getBookName() != null && !requestBookDto.getBookName().trim().isEmpty()) {
            this.bookName = requestBookDto.getBookName();
        }
        if (requestBookDto.getAuthor() != null && !requestBookDto.getAuthor().trim().isEmpty()) {
            this.author = requestBookDto.getAuthor();
        }
        if (requestBookDto.getPublisher() != null && !requestBookDto.getPublisher().trim().isEmpty()) {
            this.publisher = requestBookDto.getPublisher();
        }
        if (requestBookDto.getYear() != null && requestBookDto.getYear() > 0) {
            this.year = requestBookDto.getYear();
        }
    }
}
