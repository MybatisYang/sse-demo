package com.ht.ssedemo.util;

import okhttp3.*;

import java.io.IOException;
import java.time.Duration;

/**
 * @Description: receipt
 * @Author: yjs
 * @createTime: 2022年06月27日 14:53:53
 * @version: 1.0
 */
public class receipt {
    public static void main(String[] args) {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                //远程服务器地址
                .host("localhost")
                //端口
                .port(8188)
                .addPathSegment("/ewit/api/receipt/cap")
                .addQueryParameter("senderCode", "152200000000-AMP")
                .build();
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .get().build();
            OkHttpClient client = new OkHttpClient.Builder().readTimeout(Duration.ZERO).build();
            try (Response response = client.newCall(request).execute()) {
                System.out.println(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
