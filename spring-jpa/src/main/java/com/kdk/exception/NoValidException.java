package com.kdk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NoValidException extends RuntimeException {

  public NoValidException(String msg) {
    super("NoValidException, ".concat(msg));
  }
}
