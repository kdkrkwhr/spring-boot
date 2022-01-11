package com.kdk.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BundleFcmRequestDto {

  private List<FcmRequestDto> fcmBody;
  private String serviceKey;

}
