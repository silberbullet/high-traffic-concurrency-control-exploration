package com.develop.transaction.api.controller;

import com.develop.transaction.config.controller.RestControllerEnvelopPattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestControllerEnvelopPattern
@RequestMapping("/api/v1/ping")
public class PingController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
