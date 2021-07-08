package com.kdk.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class BookRequestDto {

  private String userName;

  private String bookName;

}
