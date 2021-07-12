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
import com.kdk.common.ResultVo;
import com.kdk.dto.BookRequestDto;
import com.kdk.repo.book.Book;
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

  @ApiOperation(value = "JPA 입력 API", tags = "JPA")
  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "bookName", value = "책 이름", required = true),
  })
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public ResponseEntity<ResultVo> insert(@RequestBody BookRequestDto book) {
    ResultVo result = ResultVo.builder().resultData(service.bookInsert(book)).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "idx", value = "Index", required = true),
  })
  @ApiOperation(value = "JPA 조회 API", tags = "JPA")
  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public ResponseEntity<ResultVo> select(String idx) {
    ResultVo result = ResultVo.builder().resultData(service.bookSelect(idx == null ? "0" : idx.trim())).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "idx", value = "조회 Index", required = true),
    @ApiImplicitParam
    (name = "bookName", value = "책 이름", required = true),
  })
  @ApiOperation(value = "JPA 수정 API", tags = "JPA")
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public ResponseEntity<ResultVo> update(@RequestBody Book book) {
    ResultVo result = ResultVo.builder().resultData(service.bookUpdate(book)).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @ApiOperation(value = "JPA 삭제 API", tags = "JPA")
  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "idx", value = "조회 Index", required = true),
  })
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public ResponseEntity<ResultVo> delete(String idx) {
    ResultVo result = ResultVo.builder().resultData(service.bookDelete(idx)).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
