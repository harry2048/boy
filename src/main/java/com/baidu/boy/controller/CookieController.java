package com.baidu.boy.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CookieController {

    @CrossOrigin
    @GetMapping("/testString")
    public Map<String, Object> testString() {
        String url = "http://localhost:5601/internal/security/login";
        HttpHeaders headers = new HttpHeaders();
        headers.add("kbn-xsrf","123");
        Map<String, Object> map = new HashMap<>(2);
        map.put("username", "elastic");
        map.put("password", "123456");
        HttpEntity<Object> entity = new HttpEntity<>(map, headers);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, Object.class);
        String cookie = exchange.getHeaders().get("set-cookie").get(0).split(";")[0];




        Map<String, Object> result = new HashMap<>();
        result.put("kbn_cookie", cookie);
        return result;
    }
}
