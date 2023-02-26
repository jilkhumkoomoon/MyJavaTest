package com.mycode.myjavatest.io.filedemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * RandomAccessFile part one
 * */
//public class RafDemo {
//    public static void main(String[] args)  throws IOException{
//        File demo = new File("E:\\work\\project\\MY_CODING_TEST\\java_coding\\files\\demo");
//        if(!demo.exists()) {
//            demo.mkdir();
//        }
//        File file = new File(demo, "raf.dat");
//        if(!file.exists()) {
//            file.createNewFile();
//        }
//        RandomAccessFile raf = new RandomAccessFile(file, "rw");
//        System.out.println(raf.getFilePointer());
//        raf.write('A');
//
//        System.out.println(raf.getFilePointer());
//        raf.write('B');
//
//        int i = 0x7fffffff; //0111 1111 1111 1111 1111 1111 1111 1111  127
//        /**
//         * << 表示左移运算符
//         * >> 表示右移运算符
//         * >>> 表示无符号右移运算符
//         *
//         * 一次只能写如一个字节，所以一个int数据需要写4次
//         * */
//        raf.write(i>>>24);//写入高8位
//        raf.write(i >>> 16);
//        raf.write(i >>> 8);
//        raf.write(i);
//        System.out.println("##"+raf.getFilePointer());
//
//        raf.writeInt(i);
//        System.out.println("@@"+raf.getFilePointer());
//        raf.seek(12); //移动偏移
//        String s = "中";
//        byte[] gbk = s.getBytes("gbk");
//        raf.write(gbk);
//        System.out.println(raf.length());
//
//        /**
//         * 读文件需要将偏移移动到头部
//         * */
//        //raf.seek(0);
//        byte[] buf = new byte[(int)raf.length()];//默认初始化为0
//        raf.read(buf,0,buf.length);
//        //raf.read(buf);
//
//        System.out.println(Arrays.toString(buf));
//        for (byte b : buf) {
//            System.out.println(Integer.toHexString(b & 0xff)+" ");
//        }
//        raf.close();
//
//
//    }
//}

/**
 * RandomAccessFile part two
 * */


