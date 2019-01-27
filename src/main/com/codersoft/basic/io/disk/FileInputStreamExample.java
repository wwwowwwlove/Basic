package com.codersoft.basic.io.disk;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 文件输入流 Example
 */
public class FileInputStreamExample {

    public static void main(String[] args) {
        String decodePath = null;
        try {
            decodePath = URLDecoder.decode(FileOutputStreamExample.class.getClassLoader().getResource("disk/example.txt").getPath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder(1024);

        try (FileInputStream fis = new FileInputStream(decodePath);

        ) {
            byte[] temp = new byte[1024];
            int i = 0;
            while((i=fis.read(temp)) > -1){
                stringBuilder.append(new String(temp));
            }

            System.out.println("读取到的字符串："+stringBuilder.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
