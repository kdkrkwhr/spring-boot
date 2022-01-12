package com.kdk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.kdk.domain.FcmRequestDto;
import com.kdk.domain.BundleFcmRequestDto;
import com.kdk.service.FcmServerService;
import com.kdk.util.CommonConstant;
import com.kdk.util.FcmDataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "FcmSendRestApiController")
@RestController
@RequestMapping("/api")
public class FcmSendRestApiController {

  static final Logger logger = LoggerFactory.getLogger(FcmSendRestApiController.class);

  @Autowired
  private FcmServerService fcmService;

  @ApiOperation(value = "멀티 전송 API", tags = "FCM 알림 전송")
  @RequestMapping(value = "/send/multi", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<Object> sendMultiDevice(@RequestBody FcmRequestDto req)
      throws Exception {
    HashMap<String, Object > responseMp = new HashMap<String, Object>();
    long resultCode;

    String serviceKey = req.getServiceKey() == null ? "" : req.getServiceKey();
    String[] tokens = req.getTokens().length == 0 ? new String[0] : req.getTokens();
    String title = req.getTitle() == null ? "" : req.getTitle();
    String message = req.getMessage() == null ? "" : req.getMessage();
    String notifications;

    notifications = FcmDataUtil.pushMultiDataProcessing(tokens, title, message);

    HttpHeaders headers = new HttpHeaders();
    MediaType mediaType = new MediaType("application", "json", StandardCharsets.UTF_8);
    headers.setContentType(mediaType);

    HttpEntity<String> request = new HttpEntity<>(notifications, headers);

    CompletableFuture<HashMap<String, Object>> pushNotification = fcmService.send(request, serviceKey);
    CompletableFuture.allOf(pushNotification).join();

    try {

      logger.debug("request :: {}", request);
      Object firebaseResponse = pushNotification.get();
      responseMp.put("fcmResponse", firebaseResponse);
      resultCode = CommonConstant.ResponseUtil.API_RESULT_CODE_SUCC;

    } catch (InterruptedException e) {
      responseMp.put("errorMessage", e.getMessage());
      resultCode = CommonConstant.ResponseUtil.API_RESULT_CODE_FAIL;

    } catch (ExecutionException e) {
      responseMp.put("errorMessage", e.getMessage());
      resultCode = CommonConstant.ResponseUtil.API_RESULT_CODE_FAIL;
    }

    responseMp.put(CommonConstant.ResponseUtil.API_RESULT_CODE_KEY, resultCode);
    return new ResponseEntity<>(responseMp, HttpStatus.OK);
  }

  @ApiOperation(value = "단일 전송 API", tags = "FCM 알림 전송")
  @RequestMapping(value = "/send/one", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<Object> sendOneDevice(@RequestBody BundleFcmRequestDto req)
      throws Exception {
    HashMap<String, Object > responseMp = new HashMap<String, Object>();
    long resultCode;

    String serviceKey = req.getServiceKey() == null ? "" : req.getServiceKey();

    try {

      for (FcmRequestDto fcmData : req.getFcmBody()) {
        String notifications = FcmDataUtil.pushOneDataProcessing(fcmData.getToken(), fcmData.getTitle(), fcmData.getMessage());

        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType("application", "json", StandardCharsets.UTF_8);
        headers.setContentType(mediaType);

        HttpEntity<String> request = new HttpEntity<>(notifications, headers);
        CompletableFuture<HashMap<String, Object>> pushNotification = fcmService.send(request, serviceKey);
        CompletableFuture.allOf(pushNotification).join();

      }

      resultCode = CommonConstant.ResponseUtil.API_RESULT_CODE_SUCC;

    } catch (Exception e) {
      responseMp.put("errorMessage", e.getMessage());
      resultCode = CommonConstant.ResponseUtil.API_RESULT_CODE_FAIL;
    }

    responseMp.put(CommonConstant.ResponseUtil.API_RESULT_CODE_KEY, resultCode);

    return new ResponseEntity<>(responseMp, HttpStatus.OK);
  }

}
