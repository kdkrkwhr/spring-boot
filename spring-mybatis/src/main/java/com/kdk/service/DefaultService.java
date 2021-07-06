package com.kdk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kdk.domain.DefaultDto;
import com.kdk.mapper.DefaultMapper;

@Service
public class DefaultService {

  @Autowired
  private DefaultMapper mapper;

  public DefaultDto defaultSelect(String parameter) {
    return mapper.defaultSelect(parameter);
  }
}
