package com.mycode.myjavatest.io.filedemo;

import com.mycode.myjavatest.io.IOUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * FileDemo part one
 * */
/*
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("E:\\work\\project\\MY_CODING_TEST\\java_coding\\files");
        if(!file.exists()) {
            file.mkdir();
        } else {
            file.delete();
        }
        System.out.println(file.isDirectory());

        System.out.println(file.isFile());

        File file1 = new File("E:\\work\\project\\MY_CODING_TEST\\java_coding\\files\\日记.txt");
        if(!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            file1.delete();
        }

        System.out.println(file); //E:\work\project\MY_CODING_TEST\java_coding\files  打印的式文件夹的绝对路径
        System.out.println(file.getParentFile().getAbsolutePath()); //E:\work\project\MY_CODING_TEST\java_coding  当前文件夹节点的父节点的绝对路径
        System.out.println(file1.getAbsolutePath()); //E:\work\project\MY_CODING_TEST\java_coding\files\日记.txt  文件的绝对路径
        System.out.println(file.getName()); //files  路径最后一个文件节点的名称，不含路径
        System.out.println(file1.getName()); //日记.txt 文件的名称，不含路径
        System.out.println(file.getParent());  //E:\work\project\MY_CODING_TEST\java_coding  带路径  等效于file.getParentFile().getAbsolutePath()
        System.out.println(file1.getParent());  //E:\work\project\MY_CODING_TEST\java_coding\files 带路径 等效于file1.getParentFile().getAbsolutePath()
    }
}
*/
/**
 * FileDemo part two
 * */

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("E:\\testffmpeg");

        /**
         * File 的list()返回子目录的第一层文件的名称，不会递归下一级
         * */
//        String[] filenames = file.list();
//        for (String s: filenames) {
//            System.out.println(s);
//        }
//         String[] filenames = file.list(new FilenameFilter() {
//             @Override
//             /**
//              * 筛选结尾是"gradle"的
//              * */
//             public boolean accept(File dir, String s) {
//                 //System.out.println(dir + "\\" +s);
//                 if(s.endsWith("gradle")) {
//                     System.out.println(dir + "\\" +s);
//                     return true;
//                 }
//                 return false;
//             }
//         });
//         for (String s: filenames) {
//            System.out.println(s);
//        }

         /**
          * File 的listFiles()返回的是File的抽象，可以递归获取所有路径
          * */
//         File[] files = file.listFiles(new FileFilter() {
//             @Override
//             public boolean accept(File file) {
//                 System.out.println(file);
//                 return false;
//             }
//         });

        /**
         * 使用listFiles()递归输出制定文件路径下的所有文件
         * */
       FileUtils.listDirectory(file);
    }
}






























