package com.kdk.controller;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kdk.service.DefaultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "MainRestController")
@RestController
@RequestMapping("/api")
public class MainRestController {

  static final Logger logger = LoggerFactory.getLogger(MainRestController.class);

  @Autowired
  private DefaultService service;

  @ApiOperation(value = "MyBatis 조회 API", tags = "MyBatis")
  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public ResponseEntity<HashMap<String, Object>> select(String parameter) {
    HashMap<String, Object> result = new HashMap<String, Object>();
    result.put("result", service.defaultSelect(parameter == null ? "" : parameter.trim()));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
