package com.kdk.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DefaultDto {

  private Long idx;
  private String result;

}
