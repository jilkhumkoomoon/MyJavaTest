package com.mycode.myjavatest.io;

public class IoTest {

    public static void main(String[] args) {
        String s = "慕课ABC";
        byte[] bts = s.getBytes();
        for(byte b : bts) {
            /**
             * toHexString()将字节转换为了int(32位)并以16进制的方式显示
             * b & 0xff是将32位的前24位去掉，只保留后8位
             * AS默认是采用UTF-8编码的：中文占3个字节，英文占1个字节
             * */
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }


//        /System.out.print("hello");
    }
}
