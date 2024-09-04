package com.develop.transaction.web;


import com.develop.transaction.api.controller.PingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PingController.class)
public class EnvelopPatternTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void responseTest() throws Exception {
        MvcResult result =   mockMvc.perform(get("/api/v1/ping/test"))
                .andExpect(status().isOk())// 응답 상태가 200 OK 인지 확인
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println("Response Content: " + content);
    }
}
