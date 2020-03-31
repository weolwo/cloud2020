package com.poplar.tool;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Create BY poplar ON 2020/3/28
 */
public class UnitTestTool {
    private static final MediaType contentType = MediaType.parse("application/json;charset=utf-8");

    public static String doRequest(String url, Map<String, String> head, Map<String, Object> params, String requestMethod) {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder build = new FormBody.Builder();
        Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            build.add(entry.getKey(), entry.getValue().toString());
        }
        RequestBody requestBody = build.build();
        head = checkHead(head);
        Request request = null;
        if (requestMethod.equalsIgnoreCase("GET")) {
            request = new okhttp3.Request.Builder().url(url).headers(Headers.of(head)).get().build();
        } else {
            request = new okhttp3.Request.Builder().url(url).headers(Headers.of(head)).post(requestBody).build();
        }
        String str = "";
        try {
            Response response = client.newCall(request).execute();
            str = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "错误";
        }
        return str;
    }

    public static String postForObject(String url, Map<String, String> head, String json) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(contentType, json);
        head = checkHead(head);
        Request request = new okhttp3.Request.Builder().url(url).headers(Headers.of(head)).post(requestBody).build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "错误";
        }
    }

    private static Map<String, String> checkHead(Map<String, String> head) {
        if (Objects.isNull(head)) {
            HashMap<String, String> map = new HashMap<>(1);
            map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4093.3 Safari/537.36");
            head = map;
        }
        return head;
    }
}
