package com.chaewon.skinote.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/hello")
    public String hello() {
        return "백엔드 연결 성공!";
    }
}
