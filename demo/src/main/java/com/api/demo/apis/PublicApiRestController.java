package com.api.demo.apis;

import com.api.demo.configures.web.Pageable;
import com.google.gson.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam(value = "returnType", defaultValue = "JSON", required = false) @NonNull String returnType,
            @RequestParam(value = "cond", defaultValue = "", required = false) @Nullable String cond,
            Pageable pageRequest
    ) throws Exception {
        String apiURL = "/apnmOrg/v1/list";
        try {
            String urlStr = BASE_URL + apiURL + serviceKey;
            return GSON.fromJson(requestGet(createApnmOrgV1Query(urlStr, pageRequest, returnType, cond)), ReceiveDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String createApnmOrgV1Query(String urlStr, Pageable pageRequest, String returnType, String cond) {
        StringBuilder query = new StringBuilder(urlStr);
        query.append(String.format("&page=%d", pageRequest.getPage()));
        query.append(String.format("&perPage=%d", pageRequest.getPerPage()));
        query.append(String.format("&returnType=%s", returnType));
        if (StringUtils.hasText(cond)) {
            query.append(String.format("&cond[orgZipaddr::LIKE]=%s", cond));
        }
        return query.toString();
    }

    private String requestGet(String query) {
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL(query);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                result.append(line + "\n");
            }
            br.close();
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
