package com.dev.web;

import com.dev.common.KafkaRequest;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dev.common.KafkaResult;
import com.dev.service.KafkaProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "MainRestController")
@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaRestController {

  @Autowired
  private KafkaProducerService service;

  @ApiOperation(value = "Kafka 메시지 전송", tags = "Kafka")
  @PostMapping(value = "/send")
  public ResponseEntity<KafkaResult> insert(@RequestBody @Valid KafkaRequest request) {
    KafkaResult result = KafkaResult.builder().resultData(service.sendMessage(request)).build();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping(value = "/exception/null-point")
  public void nullPointerExceptionControl() {
    throw new NullPointerException();
  }

  @GetMapping(value = "/exception/run-time")
  public void runTimeExceptionControl() {
    throw new RuntimeException();
  }

  @ExceptionHandler(value = NullPointerException.class)
  public void handleNullPointerException() {
    log.error("NullPointer Exception");
  }

  @ExceptionHandler(value = RuntimeException.class)
  public void andleRuntimeException() {
    log.error("RunTime Exception");
  }
}
