package com.kdk.web;

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
import com.kdk.domain.BookRequestDto;
import com.kdk.service.BookService;
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
  private BookService service;

  @ApiOperation(value = "Elasticsearch Data 입력 API", tags = "Elasticsearch")
  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "book", value = "입력 데이터", required = true),
  })
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public ResponseEntity<ResultVo> insert(@RequestBody BookRequestDto book) {
    ResultVo result = ResultVo.builder().resultData(service.bookInsert(book)).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "userName", value = "사용자 이름", required = true),
  })
  @ApiOperation(value = "Elasticsearch Data 조회 API", tags = "Elasticsearch")
  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public ResponseEntity<ResultVo> select(String userName) {
    ResultVo result = ResultVo.builder().resultData(service.bookSelect(userName == null ? "" : userName.trim())).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @ApiOperation(value = "Elasticsearch Data 삭제 API", tags = "Elasticsearch")
  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "idx", value = "데이터 Index", required = true),
  })
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public ResponseEntity<ResultVo> delete(String idx) {
    ResultVo result = ResultVo.builder().resultData(service.bookDelete(idx == null ? "" : idx.trim())).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
