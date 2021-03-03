package com.baidu.boy.io;

import java.io.*;
import java.util.UUID;

public class TestDataStream {

    public static void main(String[] args) {
        String s = UUID.randomUUID().toString().substring(0, 6);
        System.out.println(s);
    }

    public static void main2(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        try {
//            dos.writeDouble(Math.random());
            dos.writeBytes(0x01+"name");
            dos.write(0x01);
            dos.writeBytes("age3");
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            // bais.available()方法返回其占用的字节数目，double（8-byte）+boolean（1-byte）=9-byte
            System.out.println("bais.available() = " + bais.available());
            DataInputStream dis = new DataInputStream(bais);
            // 先存进去的是Double类型数据+Boolean类型的数据
            // 因此在读取时，也应该给先读取Double类型数据+Boolean类型的数据
//            System.out.println(dis.readDouble());
//            System.out.println(dis.readBoolean());

            for (int i = 0; i < 2; i++) {
                int len = dis.read();
                System.out.println("(char)len = " + (char) len);
                len = (i+1)*4;
                System.out.println("len = " + len);
                byte[] byt = new byte[4];
                dis.readFully(byt);
                System.out.println("new String(byt) = " + new String(byt));
            }



            dos.close();
            dis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        try {
//            dos.writeDouble(Math.random());
            dos.writeDouble(2.2);
            dos.writeBoolean(true);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            // bais.available()方法返回其占用的字节数目，double（8-byte）+boolean（1-byte）=9-byte
            System.out.println("bais.available() = " + bais.available());
            DataInputStream dis = new DataInputStream(bais);
            // 先存进去的是Double类型数据+Boolean类型的数据
            // 因此在读取时，也应该给先读取Double类型数据+Boolean类型的数据
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            dos.close();
            dis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}