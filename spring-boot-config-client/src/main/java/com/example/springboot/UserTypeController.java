package com.example.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class UserTypeController {

    @Value("${user.type}")
    private String userType;

    @Value("${error.type}")
    private String errorType;

    @GetMapping("/userType")
    String getUserType() {
        return this.userType;
    }

    @GetMapping("/errorType")
    String getErrorType() {
        return this.errorType;
    }
}
