package com.kdk.service;

import java.io.IOException;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.kdk.util.CommonConstant;

@Service
public class KafkaConsumerService {

  static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
  final Serde<String> stringSerde = Serdes.String();
  final Serde<Long> longSerde = Serdes.Long();

  KStream<String, String> textLines = builder.stream("streams-plaintext-input", Consumed.with(stringSerde, stringSerde));
  @KafkaListener(topics = CommonConstant.KAFKA_TOPIC, groupId = "dev")
  public void consume(String message) throws IOException {
    logger.info("Consume Message :: {}", message);
  }

  @KafkaListener(topics = "kdk-topic2", groupId = "dev" )
  public void consume2(String message) throws IOException {
    logger.info("Consume Message 2 :: {}", message);
  }
}
