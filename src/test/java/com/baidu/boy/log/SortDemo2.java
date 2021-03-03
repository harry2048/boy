package com.baidu.boy.log;

public class SortDemo2 {
    public static void main1(String[] args) {
        int maxValue = 10;
        for (int i = 0; i < 100; i++) {
            int x = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        DemoImpl demo = new DemoImpl();
        demo.test();
    }
}

interface InDemo{
    default void test() {
        System.out.println("str");
    }
}

class DemoImpl implements InDemo{

}