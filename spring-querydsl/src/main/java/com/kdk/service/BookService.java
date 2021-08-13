package com.kdk.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kdk.dto.BookRequestDto;
import com.kdk.exception.NoValidException;
import com.kdk.exception.SavingsException;
import com.kdk.repo.book.Book;
import com.kdk.repo.book.BookRepository;
import com.kdk.repo.book.QBook;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class BookService {

  @Autowired
  private BookRepository repository;

  @Autowired
  private EntityManager em;

  static private QBook qBook = QBook.book;

  public Book bookInsert(BookRequestDto book) throws SavingsException {
    if (book == null || book.getBookName() == null)
      throw new NoValidException("BookName Check");

    return repository.save(Book.builder().bookName(book.getBookName()).build());
  }

  public Book bookSelectOne(String idx) {
    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    Book book = queryFactory.selectFrom(qBook)
        .where(qBook.idx.eq(Long.parseLong(idx)))
        .fetchOne();

    return book;
  }

  public List<Book> bookSelectList() {
    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    List<Book> bookList = queryFactory.selectFrom(qBook).fetch();

    return bookList;
  }

  @Transactional
  public long bookUpdate(Book book) throws SavingsException {
    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    long result = queryFactory.update(qBook)
        .where(qBook.idx.eq(book.getIdx()))
        .set(qBook.bookName, book.getBookName()).execute();

    return result;
  }

  @Transactional
  public long bookDelete(String idx) {
    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    long result = queryFactory.delete(qBook)
        .where(qBook.idx.eq(Long.parseLong(idx))).execute();

    return result;
  }
}
