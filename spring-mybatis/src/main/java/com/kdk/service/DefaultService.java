package com.kdk.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kdk.domain.DefaultDto;
import com.kdk.mapper.DefaultMapper;

@Service
public class DefaultService {

  @Autowired
  private DefaultMapper mapper;

  public int defaultInsert(HashMap<String, Object> data) {
    return mapper.defaultInsert(data);
  }

  public DefaultDto defaultSelect(String idx) {
    return mapper.defaultSelect(idx);
  }

  public int defaultUpdate(HashMap<String, Object> data) {
    return mapper.defaultUpdate(data);
  }

  public int defaultDelete(String idx) {
    return mapper.defaultDelete(idx);
  }
}
