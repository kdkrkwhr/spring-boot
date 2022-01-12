package com.kdk.util;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisManageUtil {

  static final Logger logger = LoggerFactory.getLogger(RedisManageUtil.class);

  @Autowired
  RedisTemplate<String, Object> redisTemplate;

  public Set<String> getRedisKeyList(String keyPatterns) {
    Set<String> keys;
    keys = redisTemplate.keys(keyPatterns.concat("*"));
    return keys;
  }

  public Object getRedisData(String key) {
    Object result = new Object();
    ValueOperations<String, Object> vop = redisTemplate.opsForValue();

    result = (vop.get(key) == null ? CommonConstant.REDIS_NO_DATA : vop.get(key));

    return result;
  }

  public Set<String> getRedisDatas(String key) {
    Set<String> datas;

    try {

      datas = redisTemplate.keys(key.concat("*"));

    } catch (Exception e) {
      datas = new HashSet<String>();
    }

    return datas;
  }

  public boolean getRedisZData(String key, long start, long end ) {
    boolean result;

    try {

      result = true;

    } catch (Exception e) {
      result = false;
    }

    return result;
  }

  public boolean setRedisData(String key, Object value) {
    ValueOperations<String, Object> vop = redisTemplate.opsForValue();
    boolean result;

    try {

      vop.set(key, value);
      result = true;

    } catch (Exception e) {
      result = false;
    }

    return result;
  }

  public boolean setRedisZData(String key, Object value, Double score) {
    ZSetOperations<String, Object> vop = redisTemplate.opsForZSet();
    boolean result;

    try {

      vop.add(key, value, score);
      result = true;

    } catch (Exception e) {
      result = false;
    }

    return result;
  }

  public boolean setRedisData(String key, Object value, long time) {
    ValueOperations<String, Object> vop = redisTemplate.opsForValue();
    boolean result;

    try {

      vop.set(key, value, time, TimeUnit.MINUTES);
      result = true;

    } catch (Exception e) {
      result = false;
    }

    return result;
  }

  public boolean delRedisData(String key) {
    boolean result;

    try {

      result = redisTemplate.delete(key);

    } catch (Exception e) {
      result = false;
    }

    return result;
  }
}
