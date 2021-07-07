package com.kdk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicatedException extends RuntimeException {

  public DuplicatedException(String msg) {
    super("DuplicatedException, ".concat(msg));
  }
}
