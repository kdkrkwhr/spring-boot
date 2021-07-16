package com.kdk.service;

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

  public String sendMessage(String message) {
    logger.info("Send Message :: {}", message);
    this.kafkaTemplate.send(CommonConstant.KAFKA_TOPIC, message);
    return message;
  }
}
