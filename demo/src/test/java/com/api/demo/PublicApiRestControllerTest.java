package com.api.demo;

import com.api.demo.apis.PublicApiRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PublicApiRestController.class)
public class PublicApiRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))  // 필터 추가
                .alwaysDo(print())
                .build();
    }

    @Test
    public void callApi() throws Exception {
        mockMvc.perform(get("/api")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("page", "2")
                        .param("perPage", "30")
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

}
