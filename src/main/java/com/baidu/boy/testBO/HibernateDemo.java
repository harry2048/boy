package com.baidu.boy.testBO;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
public class HibernateDemo {
    public String name = "a";

    public void saveA(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) throws IOException {
        URL resource = HibernateDemo.class.getClassLoader().getResource("");
        String path = resource.getPath();
        System.out.println(path);


//        HibernateDemo.class.getClassLoader().getResourceAsStream("/");

        String path1 = HibernateDemo.class.getResource("/").getPath();
        System.out.println("path1:" +path1);

        String path2 = HibernateDemo.class.getResource("").getPath();
        System.out.println("path2:" +path2);

        String path3 = new File("").getAbsolutePath();
        System.out.println("path3:"+path3);

        String path4 = new File("").getCanonicalPath();
        System.out.println("path4:" +path4);
    }
}
