package com.mycode.myjavatest.io.filedemo;

import java.io.File;

public class FileUtils {
    public static void listDirectory(File dir) {
        File[] files = dir.listFiles();
        if(files != null && files.length > 0) {
            /**
             * 递归到最后一个节点才输出文件的路径
             * */
            for (File f: files) {
                if(f.isDirectory()) {
                    listDirectory(f);
                } else {
                    System.out.println(f);
                }
            }
        }
    }
}
