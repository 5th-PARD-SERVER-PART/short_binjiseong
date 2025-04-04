package com.pard.asg2.book.entitiy;


import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Book {//바로 db생성인자
    private long bookId;
    private String bookName;
    private String author;
    private String publisher;
    private long year;
}
