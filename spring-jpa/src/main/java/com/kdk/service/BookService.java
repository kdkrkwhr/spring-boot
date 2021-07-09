package com.kdk.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kdk.dto.BookRequestDto;
import com.kdk.exception.NoValidException;
import com.kdk.exception.SavingsException;
import com.kdk.repo.book.Book;
import com.kdk.repo.book.BookRepository;

@Service
public class BookService {

  @Autowired
  private BookRepository repository;

  public Book bookInsert(BookRequestDto book) throws SavingsException {
    if (book == null || book.getBookName() == null)
      throw new NoValidException("BookName Check");

    return repository.save(Book.builder().bookName(book.getBookName()).build());
  }

  public Optional<Book> bookSelect(String idx) {
    return repository.findById(Long.parseLong(idx));
  }

  public Book bookUpdate(Book book) throws SavingsException {
    if (book == null || book.getBookName() == null || book.getIdx() == null)
      throw new NoValidException("Parameter Data Check");
    Book targetBook = repository.findById(book.getIdx()).get();
    targetBook.setBookName(book.getBookName());

    return repository.save(targetBook);
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
