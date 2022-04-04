package com.api.demo.controllers;

import com.api.demo.feignclients.PublicApiRestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PublicApiRestController.class)
public class PublicApiRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private PublicApiRestClient parc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))  // 필터 추가
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("미입력 테스트")
    public void callApi() throws Exception {
        mockMvc.perform(get("/api")
                        .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(PublicApiRestController.class))
                .andExpect(handler().methodName("apnmOrgV1"));
    }

    @Test
    @DisplayName("page={-1}, perPage={30}, cond={수원시} 입력 테스트")
    public void callApi2() throws Exception {
        mockMvc.perform(get("/api")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("page", "-1")
                        .param("perPage", "30")
                        .param("cond", "수원시")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(PublicApiRestController.class))
                .andExpect(handler().methodName("apnmOrgV1"));
    }

    @Test
    @DisplayName("cond={안산시} 입력 테스트")
    public void callApi3() throws Exception {
        mockMvc.perform(get("/api")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("cond", "안산시")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(PublicApiRestController.class))
                .andExpect(handler().methodName("apnmOrgV1"));
    }

    @Test
    public void longPaserTest() {
        Assertions.assertThrows(NumberFormatException.class, () -> Long.parseLong("qweeqwe"));

        Assertions.assertThrows(NumberFormatException.class, () -> Long.parseLong("999999999999999999999999999999999999999"));
    }

}