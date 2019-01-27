package com.codersoft.basic.io.disk;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 字节流转字符流 Example
 * 通过字符流写入文件  用到了OutputStreamWriter这个桥梁 将字符流转化为字节流
 */
public class OutputStreamWriterExample {

    public static void main(String[] args) {
        String decodePath = null;
        try {
            decodePath = URLDecoder.decode(FileOutputStreamExample.class.getClassLoader().getResource("disk/example.txt").getPath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String content = "hello , 这是经过OutputStreamWriter流转换后写入的文本喔！";

        try(FileOutputStream fos = new FileOutputStream(decodePath);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            //增强流
            BufferedWriter bw = new BufferedWriter(osw);
        ){
            bw.write(content);
            bw.newLine();
            bw.write(content);
//            osw.write(content);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
