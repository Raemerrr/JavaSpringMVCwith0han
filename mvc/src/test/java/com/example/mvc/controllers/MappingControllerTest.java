/*
 * MappingControllerTest
 * mvc
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-11-05.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */

package com.example.mvc.controllers;

import com.example.mvc.models.ReceiveDTO;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class MappingControllerTest {
    private static final String baseUrl = "https://api.odcloud.kr/api";

    @Test
    public void callApiTest() throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String serviceKey = "o9uwr1Oca7iP8zVOCdDgcndcKE8bdJjwZDmQ%2FWVzldc5fnxyuOrIr4V0OqTPjfdiiWvyOxEsnESDYlf0YEAOdQ%3D%3D";
            String urlString = String.format("%s/apnmOrg/v1/list?serviceKey=%s", baseUrl, serviceKey);
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String buffer;
            while ((buffer = bufferedReader.readLine()) != null) {
                stringBuffer.append(buffer);
            }
            bufferedReader.close();
            urlConnection.disconnect();

            Gson gson = new Gson();
            ReceiveDTO receiveDTO = gson.fromJson(stringBuffer.toString(), ReceiveDTO.class);

            System.out.println(receiveDTO.getCurrentCount());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}