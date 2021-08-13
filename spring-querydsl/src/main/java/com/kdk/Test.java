package com.kdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    String result = getHumErrorHexCodeParsingToString("210", "code");
    System.out.println("result :: " + result);
  }

  public static String getHumErrorHexCodeParsingToString(String codeStr, String parsingType) {
    String result = "";
    List<HashMap<String, Object>> dataList = new ArrayList<>();

    HashMap<String, Object> e7 = new HashMap<String, Object>();
    e7.put("code", "E7");
    e7.put("hexCode", 0x1000);
    e7.put("hexCodeStr", "0x1000");

    HashMap<String, Object> e8 = new HashMap<String, Object>();
    e8.put("code", "E8");
    e8.put("hexCode", 0x0002);
    e8.put("hexCodeStr", "0x0002");

    HashMap<String, Object> e10 = new HashMap<String, Object>();
    e10.put("code", "E10");
    e10.put("hexCode", 0x2000);
    e10.put("hexCodeStr", "0x2000");

    HashMap<String, Object> e11 = new HashMap<String, Object>();
    e11.put("code", "E11");
    e11.put("hexCode", 0x4000);
    e11.put("hexCodeStr", "0x4000");

    dataList.add(e7);
    dataList.add(e8);
    dataList.add(e10);
    dataList.add(e11);

    int code = Integer.parseInt(codeStr);
    int hexCode = Integer.parseInt(Integer.toHexString(code));

    for (HashMap<String, Object> eh : dataList) {
      int ehHex = Integer.parseInt(eh.get("hexCode").toString());
      if ((hexCode & ehHex) == ehHex) {
        if ("".equals(result)) {
          result += eh.get(parsingType).toString();

        } else {
          result += ",".concat(eh.get(parsingType).toString());
        }
      }
    }

    return result;
  }
}
