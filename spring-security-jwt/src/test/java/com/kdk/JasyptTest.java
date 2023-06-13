package com.kdk;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

@Slf4j
public class JasyptTest {

  public static void main(String[] args) {
    jasypt();
  }

  static void jasypt() {
    String url = "root";
    String username = "root";
    String password = "";

    System.out.println(jasyptEncoding(url));
    System.out.println(jasyptEncoding(username));
    System.out.println(jasyptEncoding(password));
  }

  public static String jasyptEncoding(String value) {
    String key = "kdkdongki1997";
    StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
    pbeEnc.setAlgorithm("PBEWithMD5AndDES");
    pbeEnc.setPassword(key);
    return pbeEnc.encrypt(value);
  }
}
