package com.kdk.service;

import java.util.Date;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import com.kdk.domain.BookRequestDto;
import com.kdk.elastic.book.BookES;
import com.kdk.elastic.book.BookRepository;
import com.kdk.exception.DeleteException;
import com.kdk.exception.SavingsException;

@Service
public class BookService {

  @Autowired
  private ElasticsearchRestTemplate esTemplate;

  @Autowired
  private BookRepository repository;

  public BookES bookInsert(BookRequestDto book) throws SavingsException {
    return repository.save(BookES.builder()
        .bookName(book.getBookName())
        .userName(book.getUserName())
        .logDate(new Date()).build());
  }

  public SearchHits<BookES> bookSelect(String userName) {
    QueryBuilder userNameSearchQuery = QueryBuilders.matchQuery("userName", userName);
    Query searchQueryUserName = new NativeSearchQueryBuilder().withQuery(userNameSearchQuery).build();
    return esTemplate.search(searchQueryUserName, BookES.class);
  }

  public boolean bookDelete(String id) {
    boolean result;

    try {

      repository.deleteById(id);
      result = true;

    } catch (Exception e) {
      throw new DeleteException("ES, DELETE Exception .");
    }

    return result;
  }
}
