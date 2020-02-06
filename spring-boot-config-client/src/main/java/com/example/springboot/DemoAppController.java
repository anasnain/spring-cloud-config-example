package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.Map;

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

    @Autowired
    ConfigMap configMap;

    @GetMapping("/query")
    String getKey(@RequestParam("key") String key ) {
        Map<String, String> query = configMap.getQuery();
        System.out.println("key = "+ key);
        System.out.println("queryMap = "+ query);
        System.out.println("query.get(key) = "+ query.get(key));
        return query.get(key);
    }

    @Resource
    private ConfigurableEnvironment environmentProperties;

    @GetMapping("/property")
    String getProperty(@RequestParam("key") String key ) {
        System.out.println("key = "+ key);
        System.out.println("environmentProperties.getProperty(key) = "+ environmentProperties.getProperty(key));
        return environmentProperties.getProperty(key);
    }
}
