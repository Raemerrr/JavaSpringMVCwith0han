package com.api.demo.apis;

import com.api.demo.configures.web.Pageable;
import com.google.gson.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("api")
public class PublicApiRestController {

    public static final String BASE_URL = "http://api.odcloud.kr/api";
    public static final String serviceKey = "?serviceKey=o9uwr1Oca7iP8zVOCdDgcndcKE8bdJjwZDmQ/WVzldc5fnxyuOrIr4V0OqTPjfdiiWvyOxEsnESDYlf0YEAOdQ==";
    private static final Gson GSON = new GsonBuilder().create();

    @GetMapping
    public ReceiveDTO apnmOrgV1(
            @RequestParam("cond") @Nullable String cond,
            Pageable pageRequest

    ) throws Exception {
        String apiURL = "/apnmOrg/v1/list";
        try {
            StringBuffer result = new StringBuffer();
            String urlStr = BASE_URL + apiURL + serviceKey;
            StringBuilder query = new StringBuilder(urlStr);
            query.append(String.format("&page=%d", pageRequest.getPage()));
            query.append(String.format("&perPage=%d", pageRequest.getPerPage()));
            URL url = new URL(query.toString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                result.append(line + "\n");
            }
            urlConnection.disconnect();
            br.close();
            return GSON.fromJson(result.toString(), ReceiveDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
