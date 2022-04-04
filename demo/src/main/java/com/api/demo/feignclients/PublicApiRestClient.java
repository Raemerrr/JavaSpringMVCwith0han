package com.api.demo.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "example", url = "${api.url}/apnmOrg")
public interface PublicApiRestClient {

    @GetMapping(value = "v1/list?page={page}&perPage={perPage}&returnType={returnType}&cond[orgZipaddr::LIKE]={cond}", headers = "Authorization=Infuser ${api.serviceKey}")
    String list(@PathVariable("page") int page, @PathVariable("perPage") int perPage, @PathVariable("cond") String returnType, @PathVariable("cond") String cond);
}

