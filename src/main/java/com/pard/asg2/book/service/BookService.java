package com.pard.asg2.book.service;

import com.pard.asg2.book.dto.BookDto;
import com.pard.asg2.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void addBook(BookDto bookDto){
        bookRepository.add(bookDto);
    }
    public BookDto findByBookId(long BookId){
        return bookRepository.findByBookId(BookId);
    }
    public BookDto findByBookName(String BookName){
        return bookRepository.findByBookName(BookName);
    }
    public void updateByBookId(long BookId, BookDto bookDto){
        bookRepository.updateByBookId(BookId,bookDto);
    }
    public void updateByBookName(String BookName, BookDto bookDto){
        bookRepository.updateByBookName(BookName,bookDto);
    }
    public void deleteByBookId(long BookId){
        bookRepository.deleteByBookId(BookId);
    }
    public void deleteByBookName(String BookName){
        bookRepository.deleteByBookName(BookName);
    }
    public List<BookDto> findAll(){
        return bookRepository.findAll();
    }
}
