package com.api.demo.apis;

import com.api.demo.dtos.RequestDTO;
import com.api.demo.feignclients.PublicApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PublicApiClientTest {

    @Autowired
    private PublicApiClient pac;

    @Test
    void test01() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setPage(1);
        requestDTO.setPage(10);
        requestDTO.setCond("안산시");
        String str = pac.list(requestDTO);
        System.out.println(str);
    }

    @Test
    void test02() {
        String str = pac.list2(1, 10, "안산시");
        System.out.println(str);
    }

    @Test
    void test03() {
        String str = pac.list3(1, 10, "안산시");
        System.out.println(str);
    }

}