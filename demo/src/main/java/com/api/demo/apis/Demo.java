package com.api.demo.apis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Demo {

    public static final String BASE_URL = "http://api.odcloud.kr/api";
    public static final String serviceKey = "?serviceKey=o9uwr1Oca7iP8zVOCdDgcndcKE8bdJjwZDmQ/WVzldc5fnxyuOrIr4V0OqTPjfdiiWvyOxEsnESDYlf0YEAOdQ==";
    private static final Gson gson = new GsonBuilder().create();

    @GetMapping
    public ReceiveDTO call(
            @RequestParam(name = "returnType", defaultValue = "JSON", required = false) @NonNull String returnType,
            @RequestParam(name = "cond", defaultValue = "", required = false) @Nullable String cond
    ) {
        ReceiveDTO receiveDTO = gson.fromJson("", ReceiveDTO.class);
        return receiveDTO;
    }


    private String requestGet(String target) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(target);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                sb.append(line + "\n");
            }
            br.close();
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private String createCallQuery(String returnType, String cond) {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL);
        //sb.append("&serviceKey=")
        return sb.toString();
    }
}
