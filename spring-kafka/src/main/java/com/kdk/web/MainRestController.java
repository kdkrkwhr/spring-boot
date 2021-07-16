package com.kdk.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kdk.common.ResultVo;
import com.kdk.service.KafkaProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "MainRestController")
@RestController
@RequestMapping("/api")
public class MainRestController {

  static final Logger logger = LoggerFactory.getLogger(MainRestController.class);

  @Autowired
  private KafkaProducerService service;

  @ApiOperation(value = "Kafka 메시지 전송", tags = "Kafka")
  @RequestMapping(value = "/send", method = RequestMethod.POST)
  public ResponseEntity<ResultVo> insert(@RequestParam String message) {
    ResultVo result = ResultVo.builder().resultData(service.sendMessage(message)).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
