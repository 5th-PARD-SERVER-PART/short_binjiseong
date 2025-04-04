package com.pard.asg2.book.repository;

import com.pard.asg2.book.dto.BookDto;
import com.pard.asg2.book.entitiy.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    private static final Map<Long,Book> handong = new HashMap<>();
    private static final Map<String,Book> handong1 = new HashMap<>();
    public void add(BookDto bookDto){
        Book book = Book.builder()
                .bookName(bookDto.getBookName())
                .author(bookDto.getAuthor())
                .bookId(bookDto.getBookId())
                .year(bookDto.getYear())
                .publisher(bookDto.getPublisher())
                .build();
        handong.put(bookDto.getBookId(), book);
        handong1.put(bookDto.getBookName(), book); // 제목 기반 map에도 저장

    }
    public BookDto findByBookId(long BookId){
       Book book = handong.get(BookId);

       return BookDto.builder()
                .bookId(book.getBookId())
                .bookName(book.getBookName())
                .author(book.getAuthor())
                .year(book.getYear())
                .publisher(book.getPublisher())
                .build();
    }
    public BookDto findByBookName(String BookName){
        Book book = handong1.get(BookName);

        return BookDto.builder()
                .bookId(book.getBookId())
                .bookName(book.getBookName())
                .author(book.getAuthor())
                .year(book.getYear())
                .publisher(book.getPublisher())
                .build();
    }
    public void updateByBookId(long BookId, BookDto bookDto){
        Book book = handong.get(BookId);

        handong1.remove(book.getBookName()); // 기존 제목 삭제
        book.setBookName(bookDto.getBookName());
        book.setAuthor(bookDto.getAuthor());
        book.setYear(bookDto.getYear());
        book.setPublisher(bookDto.getPublisher());
        handong1.put(book.getBookName(), book); // 새 제목으로 다시 추가
    }
    public void updateByBookName(String BookName, BookDto bookDto){
        Book book = handong1.get(BookName);

        handong.remove(book.getBookId()); // 기존 제목 삭제
        book.setBookName(bookDto.getBookName());
        book.setAuthor(bookDto.getAuthor());
        book.setYear(bookDto.getYear());
        book.setPublisher(bookDto.getPublisher());
        handong.put(book.getBookId(), book); // 새 제목으로 다시 추가
    }
    public void deleteByBookId(long BookId){
        Book book = handong.remove(BookId);
        if (book != null) {
            handong1.remove(book.getBookName()); // 제목으로도 제거
        }
    }
    public void deleteByBookName(String BookName){
        Book book = handong1.remove(BookName);
        if (book != null) {
            handong.remove(book.getBookId()); // id로도 제거
        }
    }
    public List<BookDto> findAll(){
       return handong.values().stream()
               .map(book -> BookDto.builder()
                   .bookId(book.getBookId())
                   .bookName(book.getBookName())
                   .author(book.getAuthor())
                   .year(book.getYear())
                   .publisher(book.getPublisher())
                   .build()).toList();
    }
}
