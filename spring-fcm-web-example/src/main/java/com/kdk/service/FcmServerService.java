package com.kdk.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.kdk.util.CommonConstant;
import com.kdk.util.HeaderRequestInterceptor;

@Service
public class FcmServerService {

  @Async
  public CompletableFuture<HashMap<String, Object>> send(HttpEntity<String> entity, String serviceKey) {
    RestTemplate restTemplate = new RestTemplate();
    ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

    interceptors.add(new HeaderRequestInterceptor("Authorization", "key=".concat(serviceKey)));
    interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json; UTF-8"));
    restTemplate.setInterceptors(interceptors);

    @SuppressWarnings("unchecked")
    HashMap<String, Object> firebaseResponse = restTemplate.postForObject(CommonConstant.FIREBASE_API_URL, entity, HashMap.class);

    return CompletableFuture.completedFuture(firebaseResponse);
  }
}
