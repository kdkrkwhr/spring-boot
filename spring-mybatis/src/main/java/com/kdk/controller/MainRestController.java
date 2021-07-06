package com.kdk.controller;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kdk.domain.ResultVo;
import com.kdk.service.DefaultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "MainRestController")
@RestController
@RequestMapping("/api")
public class MainRestController {

  static final Logger logger = LoggerFactory.getLogger(MainRestController.class);

  @Autowired
  private DefaultService service;

  @ApiOperation(value = "MyBatis 입력 API", tags = "MyBatis")
  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "result", value = "테스트 데이터", required = true),
  })
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public ResponseEntity<ResultVo> insert(@RequestBody HashMap<String, Object> request) {
    ResultVo result = ResultVo.builder().resultData(service.defaultInsert(request)).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "idx", value = "조회 Index", required = true),
  })
  @ApiOperation(value = "MyBatis 조회 API", tags = "MyBatis")
  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public ResponseEntity<ResultVo> select(String idx) {
    ResultVo result = ResultVo.builder().resultData(service.defaultSelect(idx == null ? "0" : idx.trim())).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "idx", value = "조회 Index", required = true),
    @ApiImplicitParam
    (name = "result", value = "테스트 데이터", required = true),
  })
  @ApiOperation(value = "MyBatis 수정 API", tags = "MyBatis")
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public ResponseEntity<ResultVo> update(@RequestBody HashMap<String, Object> request) {
    ResultVo result = ResultVo.builder().resultData(service.defaultUpdate(request)).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @ApiOperation(value = "MyBatis 삭제 API", tags = "MyBatis")
  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "idx", value = "조회 Index", required = true),
  })
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public ResponseEntity<ResultVo> delete(String idx) {
    ResultVo result = ResultVo.builder().resultData(service.defaultDelete(idx)).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
