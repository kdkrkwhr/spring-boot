package com.kdk.elastic.book;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Document(indexName = "book")
public class BookES {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Field(type = FieldType.Text)
  private String userName;

  @Field(type = FieldType.Text)
  private String bookName;

  @Field(type = FieldType.Date)
  private Date logDate;
}
