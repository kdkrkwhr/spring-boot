package com.kdk.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FcmRequestDto {

  private String serviceKey;
  private String token;
  private String[] tokens;
  private String title;
  private String message;

}
