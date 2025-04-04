package com.pard.asg2.book.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookDto {
    private long bookId;
    private String bookName;
    private String author;
    private String publisher;
    private long year;
}
