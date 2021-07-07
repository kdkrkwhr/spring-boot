package com.kdk.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kdk.dto.BookRequestDto;
import com.kdk.repo.book.Book;
import com.kdk.repo.book.BookRepository;

@Service
public class BookService {

  @Autowired
  private BookRepository repository;

  public Book bookInsert(BookRequestDto book) {
    return repository.save(Book.builder().bookName(book.getBookName()).build());
  }

  public Optional<Book> bookSelect(String idx) {
    return repository.findById(Long.parseLong(idx));
  }

  public Book bookUpdate(BookRequestDto book) {
    return repository.save(
        Book.builder().bookName(repository.findById(book.getIdx()).get().getBookName()).build());
  }

  public boolean bookDelete(String idx) {
    boolean result = false;

    try {

      repository.deleteById(Long.parseLong(idx));
      result = true;

    } catch (Exception e) {
      result = false;
    }

    return result;
  }
}
