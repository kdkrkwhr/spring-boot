package com.kdk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SavingsException extends RuntimeException {

  public SavingsException(String msg) {
    super(msg);
  }
}
