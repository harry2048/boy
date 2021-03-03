package com.baidu.boy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class BoyApplicationTests {


    @Test
    void contextLoads() {
        System.out.println("中文测试");
        for (int i = 0; i < 10; i++) {
            log.info("this is info" + i);
            log.warn("what's it ? -> {}", "is warn 警告");
            log.error("this is error" + i);
        }


    }

}
