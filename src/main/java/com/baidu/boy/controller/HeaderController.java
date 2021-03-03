package com.baidu.boy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HeaderController {

    @GetMapping("/headerTest")
    public String headerTest(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("mac","macResp");
        return "ok";
    }

    public static void main(String[] args) {
        String str1 = "";
        String str2 = " ";
        System.out.println(str1.equals(str2));
    }
}
