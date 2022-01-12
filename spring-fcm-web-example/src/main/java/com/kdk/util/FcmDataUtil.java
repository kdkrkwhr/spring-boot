package com.kdk.util;

import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FcmDataUtil {

  public static String pushMultiDataProcessing(String[] tokens, String title, String message)
      throws JSONException, UnsupportedEncodingException {
    JSONObject body = new JSONObject();
    JSONArray array = new JSONArray();

    for (String token : tokens) array.put(token);

    body.put("registration_ids", array);
    body.put("content_available", true);

    JSONObject notification = new JSONObject();
    notification.put("title", title);
    notification.put("body", message);

    body.put("notification", notification);

    return body.toString();
  }

  public static String pushOneDataProcessing(String token, String messageType, String message)
      throws JSONException, UnsupportedEncodingException {
    JSONObject body = new JSONObject();

    body.put("to", token);
    body.put("content_available", true);

    JSONObject notification = new JSONObject();
    notification.put("messageType", messageType);
    notification.put("message", new JSONObject(message));

    body.put("data", notification);

    return body.toString();
  }
}
