package com.kdk.service;

import com.kdk.common.KafkaRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.kdk.util.CommonConstant;

@Service
public class KafkaProducerService {

  static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public Object sendMessage(KafkaRequest request) {
    logger.info("Send Message :: {}", request.getMessage());
    this.kafkaTemplate.send(request.getMessage().isEmpty() ? CommonConstant.KAFKA_TOPIC : request.getTopic(), request.getMessage());
    return request;
  }
}
