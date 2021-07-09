package com.kdk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NoExsistException extends RuntimeException {

  public NoExsistException(String msg) {
    super("NoExsistException, ".concat(msg));
  }
}
