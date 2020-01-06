package com.example.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("demoapp")
public class DemoAppController {

    @Value("${keyA}")
    private String keyA;

    @Value("${keyB}")
    private String keyB;

    @Value("${keyC}")
    private String keyC;

    @GetMapping("/keyA")
    String getKeyA() {
        return this.keyA;
    }

    @GetMapping("/keyB")
    String getKeyB() {
        return this.keyB;
    }

    @GetMapping("/keyC")
    String getKeyC() {
        return this.keyC;
    }
}
