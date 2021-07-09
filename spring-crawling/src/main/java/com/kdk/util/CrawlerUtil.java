package com.kdk.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CrawlerUtil {

  static final Logger logger = LoggerFactory.getLogger(CrawlerUtil.class);

  public static HashMap<String, Object> findByTag(String url, String tType, String tClassName) {
    HashMap<String, Object> result = new LinkedHashMap<String, Object>();

    try {

      Document html = Jsoup.connect(url).get();

      List<String> tagList = new ArrayList<String>();
      for (Element el :html.getElementsByClass(tClassName)) {
        logger.info("value :: {}", el.getElementsByClass(tClassName));
        tagList.add(el.getElementsByClass(tClassName).toString());
      }

      result.put(tType, tagList);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }
}
