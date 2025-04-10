package com.pard.hw3.book.repo;

import com.pard.hw3.book.dto.ResponseBookDto;
import com.pard.hw3.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book,Long> {
    Optional<Book> findByBookName(String bookName);
    void deleteByBookName(String bookName);
}
