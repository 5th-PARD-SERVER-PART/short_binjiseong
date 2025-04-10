package com.pard.hw3.book.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter

@JsonPropertyOrder({"id", "bookId", "bookName", "author", "publisher", "year"})
public class RequestBookDto {
    private Long Id;
    private Long bookId;
    private String bookName;
    private String author;
    private String publisher;
    private Long year;
}
