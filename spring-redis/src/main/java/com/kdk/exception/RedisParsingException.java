package com.kdk.exception;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RedisParsingException extends JSONException {

  public RedisParsingException(String msg) {
    super("RedisParsingException, ".concat(msg));
  }
}
