package com.baidu.boy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/clientTest")
    public Map<String, Object> clientTest(@RequestBody Map<String, Object> map) {
//        System.out.println("client端获取到的参数为："+map);

        map.put("result", "我收到了");
        logger.info("map->{}",map);
        return map;
    }

    @GetMapping("/logTest")
    public Map<String, Object> logTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "我收到了");
//        map = null;
        logger.info("map -> {}", map);
//        return "I get it";
        return map;
    }
}
