package com.kdk.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kdk.dto.BookRequestDto;
import com.kdk.exception.RedisParsingException;
import com.kdk.util.RedisManageUtil;

@Service
public class BookService {

  @Autowired
  private RedisManageUtil redisUtil;

  public boolean bookInsert(BookRequestDto book) {
    return redisUtil.setRedisData(book.getUserName(), book.getBookName());
  }

  public JSONObject bookSelect(String key) throws RedisParsingException {
    JSONObject result;

    try {

      result = new JSONObject(redisUtil.getRedisData(key).toString());

    } catch (JSONException e) {
      throw new RedisParsingException("SELECT");
    }

    return result;
  }

  public boolean bookDelete(String key) {
    return redisUtil.delRedisData(key);
  }
}
