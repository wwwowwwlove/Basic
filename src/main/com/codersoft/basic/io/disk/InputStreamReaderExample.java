package com.codersoft.basic.io.disk;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 字节流转字符流 Example
 * 通过字符流读取文件  用到了InputStreamReader这个桥梁 将字节流转换成字符流
 * 体现了适配器设计模式
 */
public class InputStreamReaderExample {

    public static void main(String[] args) {
        String decodePath = null;
        try {
            decodePath = URLDecoder.decode(FileOutputStreamExample.class.getClassLoader().getResource("disk/example.txt").getPath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(decodePath);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr);
        ) {
            String str = null;
            while ((str = br.readLine()) != null ) {
                System.out.println("读取到的字符串："+str);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
