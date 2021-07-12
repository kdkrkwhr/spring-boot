package com.kdk.web;

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
import com.kdk.dto.CrRequestDto;
import com.kdk.product.ProductTagInfo;
import com.kdk.service.ShopService;
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
  private ShopService service;

  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "ProductTagInfo", value = "상품 크롤링 태그 정보", required = true),
  })
  @ApiOperation(value = "상품 크롤링 태그 등록", tags = "Crawling Service")
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public ResponseEntity<ProductTagInfo> insert(@RequestBody ProductTagInfo req) {
    return new ResponseEntity<>(service.saveProduct(req), HttpStatus.OK);
  }

  @ApiImplicitParams({
    @ApiImplicitParam
    (name = "targetDomain", value = "크롤링 대상 도메인", required = true),
    @ApiImplicitParam
    (name = "tags", value = "대상 태그", required = true),
  })
  @ApiOperation(value = "크롤링 사이트", tags = "Crawling Service")
  @RequestMapping(value = "/crawling", method = RequestMethod.GET)
  public ResponseEntity<HashMap<String, Object>> crawling(@RequestBody CrRequestDto req) {
    return new ResponseEntity<>(service.crawlingSearch(req), HttpStatus.OK);
  }
}
