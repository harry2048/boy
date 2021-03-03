package com.baidu.boy.controller;

import com.baidu.boy.config.PoinGlobalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class RemoteController {

    private static String myName;

    @Value("${myName}")
    private void setMyName(String myName) {
        RemoteController.myName = myName;
    }


    @GetMapping("/remote")
    public Map<String, Object> postRemote() {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "good");
        log.info("这是什么 ->{}", "这是kibana测试！");
        return map;
    }


    @GetMapping("/config")
    public String config() {
        log.info("what ? -> {}", "this is config");
        PoinGlobalUtil.init();
        System.out.println(myName+" - " + Thread.currentThread().getName());
        PoinGlobalUtil.saveOrUpdate("这是一个BO");

        System.out.println("=====================");
        return "good";
    }

    @GetMapping("/order")
    public String order() {
        System.out.println("==========start===========");
        log.info("what ? -> {}", "this is config "+ Thread.currentThread().getName());
        System.out.println(1);
        System.out.println(myName+" - " + Thread.currentThread().getName());
        System.out.println(2);
        System.out.println("===========end==========");
        return "good";
    }

    @GetMapping("/log")
    public void test(@RequestParam String value) {
        for (int i = 0; i < 10; i++) {
            log.info("this is info" + i + value);
            log.error("this is error" + i + value);
        }

        int x = 1/0;
    }
}
