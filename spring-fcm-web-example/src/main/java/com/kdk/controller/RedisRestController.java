package com.kdk.controller;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.kdk.util.CommonConstant;
import com.kdk.util.RedisManageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "RedisRestController")
@RestController
@RequestMapping("/redis")
public class RedisRestController {

  static final Logger logger = LoggerFactory.getLogger(RedisRestController.class);

  @Autowired
  private RedisManageUtil redisUtil;

  @ApiOperation(value = "FCM Key 저장", tags = "Redis 활용")
  @RequestMapping(value = "/key/save", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<Object> saveFcmKey(String fcmKey)
      throws Exception {
    HashMap<String, Object > responseMp = new HashMap<String, Object>();

    logger.info("FCM KEY :: {}", fcmKey);
    responseMp.put(CommonConstant.ResponseUtil.API_RESULT_CODE_KEY, redisUtil.setRedisData("key", fcmKey));

    return new ResponseEntity<>(responseMp, HttpStatus.OK);
  }
}
