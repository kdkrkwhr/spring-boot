package com.kdk.service;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.kdk.util.CommonConstant;

@Service
public class KafkaConsumerService {

  static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

  @KafkaListener(topics = CommonConstant.KAFKA_TOPIC, groupId = "kdk")
  public void consume(String message) throws IOException {
    logger.info("Consume Message :: {}", message);
  }
}
