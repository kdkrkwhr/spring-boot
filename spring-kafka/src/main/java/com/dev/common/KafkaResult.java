package com.kdk.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class KafkaResult {

  @JsonProperty("result")
  private Object resultData;
}
