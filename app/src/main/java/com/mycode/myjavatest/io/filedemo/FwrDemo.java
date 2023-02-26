package com.mycode.myjavatest.io.filedemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;

interface some {
    void doSome();
}

class A implements some {

    @Override
    public void doSome() {
        System.out.println("doSome");
    }
}

abstract class  B extends A {
    public void doBnums() {
        System.out.println("doBnums");
    }
}

class C extends B {
    public void joinB() {
        System.out.println("doCnums");
    }
}

public class FwrDemo {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("E:\\work\\project\\MY_CODING_TEST\\java_coding\\files\\test1.txt");
            /**
             * append=true 是采用追加的方式，如果文件存在就不会删除文件，否则每次都会重新删除创建新的文件
             * */
            FileWriter fw = new FileWriter("E:\\work\\project\\MY_CODING_TEST\\java_coding\\files\\test1.txt",true);

            char[] buffer = new char[2056];
            int c;
            /**
             * 这种写法是最大一次读取buffer.length的数据
             * 如果数据量小于buffer.length，就返回实际读取数据的字节数
             * 写入是从buffer的0开始取c(实际读取数据的字节数)字节写入文件中
             * */
            while((c = fr.read(buffer, 0, buffer.length)) != -1){
                System.out.println(c+buffer.toString());
                fw.write(buffer,0,c);
                fw.flush();
            }
            fr.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        some s = new C();
        ((C)s).joinB();
    }
}
