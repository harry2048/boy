package com.baidu.boy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class HttpClientController {

    @GetMapping("/getTest")
    public Map<String, Object> logTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "我收到了");
//        map = null;
        log.info("map -> {}", map);
//        return "I get it";
        return map;
    }

    @PostMapping("/postTest")
    public Map<String, Object> postTest(@RequestBody Map<String, Object> map) {
        System.out.println("接收到的参数：" + map);
        map.put("result", "I am postTest");
        return map;
    }
}
