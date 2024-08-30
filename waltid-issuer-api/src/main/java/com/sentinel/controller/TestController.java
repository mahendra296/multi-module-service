package com.sentinel.controller;

import com.sentinel.enums.FetchType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @GetMapping("/hello")
    public String Hello() {
        return FetchType.EGGER.name();
    }
}
