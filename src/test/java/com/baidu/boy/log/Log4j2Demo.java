package com.baidu.boy.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Log4j2Demo{

    @Test
    public void test() {


        for (int i = 0; i < 10; i++) {
            log.info("this is info" + i);
            log.error("this is error" + i);
        }
//        try {
//            int x = 1/0;
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw new RuntimeException(e.getMessage(),e);
//        }
//
//        log.info("this is {}", "下一环节");
    }
}
