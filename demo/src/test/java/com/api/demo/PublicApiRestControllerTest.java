package com.api.demo;

import com.api.demo.apis.PublicApiRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.concurrent.ExecutionException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PublicApiRestController.class)
public class PublicApiRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void callApi() throws Exception {
        mockMvc.perform(get("/api")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("page", "qweqwerrrr")
                        .param("perPage", "9999999999999999999999999999999")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(PublicApiRestController.class))
                .andExpect(handler().methodName("apnmOrgV1"));
    }

    @Test
    public void longPaserTest() throws Exception {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Long.valueOf("qweeqwe");
        });

        Assertions.assertThrows(NumberFormatException.class, () -> {
            Long.valueOf("999999999999999999999999999999999999999");
        });
    }

    @Test
    public void asyncRestTemplateTest() throws InterruptedException, ExecutionException {

//        Mono<String> result = webClient
//                .get()
//                .uri("/api")
//                .retrieve()
//                .bodyToMono(String.class);
//
//        result.subscribe(response -> {
//            System.out.println("response : " + response);
//        }, e -> {
//            System.out.println("error message : " + e.getMessage());
//        });
//        //getWebClient().get().exchange().block().bodyToMono(User.class).block();

    }
}
