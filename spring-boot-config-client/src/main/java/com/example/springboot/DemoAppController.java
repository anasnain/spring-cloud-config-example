package com.example.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class DemoAppController {

    @Value("${keyA}")
    private String keyA;

    @Value("${keyB}")
    private String keyB;

    @GetMapping("/keyA")
    String getUserType() {
        return this.keyA;
    }

    @GetMapping("/keyB")
    String getErrorType() {
        return this.keyB;
    }
}
