package com.kdk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.kdk.util.HandlerInterceptorUtil;

@Configuration
public class InterceptorConfig extends HandlerInterceptorAdapter {

  @Bean
  public HandlerInterceptorUtil handshakeInterceptor() {
    return new HandlerInterceptorUtil();
  }
}
