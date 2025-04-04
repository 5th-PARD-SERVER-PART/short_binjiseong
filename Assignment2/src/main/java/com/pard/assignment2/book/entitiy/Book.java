package com.pard.assignment2.book.entitiy;


import lombok.*;

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
