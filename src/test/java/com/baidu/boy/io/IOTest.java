package com.baidu.boy.io;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;

public class IOTest {

    private static final IOTest IO_TEST = new IOTest();
    private DataInputStream din;

    String str = "hello";

    private IOTest() {
        InputStream bin = IOTest.class.getClassLoader().getResourceAsStream("input.txt");
        //ByteArrayInputStream bin = new ByteArrayInputStream(str.getBytes());
        din = new DataInputStream(bin);
    }

    public static IOTest getInstance() {
        return IO_TEST;
    }


    public static void main(String[] args) throws Exception {
        IOTest.getInstance().readValue();

    }

    public void readFull2() throws Exception {
        int length = str.getBytes().length;
        for (int i = 0; i < length; i++) {
            readValue();
        }
    }

    public void readFull() throws Exception {
        int length = din.available();
        // create buffer
        byte[] buf = new byte[length];

        // read the full data into the buffer
        din.readFully(buf);

        String msg = new String(buf);
        System.out.println("数据为-> " + msg);
    }

    public byte[] readValue() throws Exception {
        int le = 0;
//        int len = din.read();
        int len = din.available();
        le++;
        byte[] ret;
        if (len < 255) {
            ret = new byte[len];
            din.readFully(ret);
            String msg = new String(ret);
            System.out.println("数据为->" + msg);
            return ret;
        }

        // 多次读取
        ByteArrayOutputStream bou = new ByteArrayOutputStream();
        byte[] buf = new byte[255];
        din.readFully(buf);
        bou.write(buf);
        while (true) {
            len = din.read();
            le++;
            if (len == 255) {
                din.readFully(buf);
                bou.write(buf);
            } else {
                byte[] lastPart = new byte[len];
                din.readFully(lastPart);
                bou.write(lastPart);
                break;
            }
        }

        return bou.toByteArray();
    }
}
