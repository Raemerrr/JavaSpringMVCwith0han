package com.api.demo.controllers;

import com.api.demo.configures.web.Pageable;
import com.api.demo.dtos.ReceiveDTO;
import com.api.demo.feignclients.PublicApiRestClient;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PublicApiRestController {

    private static final Gson GSON = new GsonBuilder().create();

    private final PublicApiRestClient parc;

    @Autowired
    PublicApiRestController(PublicApiRestClient parc) {
        this.parc = parc;
    }

    @GetMapping
    public ReceiveDTO apnmOrgV1(
            @RequestParam(value = "returnType", defaultValue = "JSON", required = false) String returnType,
            @RequestParam(value = "cond", defaultValue = "", required = false) String cond,
            Pageable pageRequest) {
        if (returnType.equalsIgnoreCase("JSON")) {
            return GSON.fromJson(parc.list(pageRequest.getPage(), pageRequest.getPerPage(), returnType, cond), ReceiveDTO.class);
        }
        return null;
    }

}
