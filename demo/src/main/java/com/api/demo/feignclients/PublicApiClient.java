package com.api.demo.feignclients;

import com.api.demo.dtos.RequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "example", url = "${api.url}/apnmOrg/v1/list")
public interface PublicApiClient {

    @GetMapping(headers = "Authorization=Infuser ${api.serviceKey}")
    String list(RequestDTO requestDTO);

    @GetMapping(headers = "Authorization=Infuser ${api.serviceKey}")
    String list2(@RequestParam("page") int page, @RequestParam("perPage") int perPage, @RequestParam(value = "cond%5BorgZipaddr%3A%3ALIKE%5D") String cond);

    @GetMapping(value = "?cond[orgZipaddr::LIKE]={cond}&page={page}&perPage={perPage}", headers = "Authorization=Infuser ${api.serviceKey}")
    String list3(@PathVariable("page") int page, @PathVariable("perPage") int perPage, @PathVariable("cond") String cond);
}

