package com.codersoft.basic.io.disk;

import java.io.*;
import java.net.URLDecoder;

/**
 * 文件输出流 Example
 */
public class FileOutputStreamExample {

    public static void main(String[] args) {
        // 获取resource下的资源文件
        String path = FileOutputStreamExample.class.getClassLoader().getResource("disk/example.txt").getPath();
        System.out.println("这是获取到的原始路径(经过编码后的)URL：" + path);
        String decodePath = null;
        try {
            /**
             * 当我们使用ClassLoader的getResource方法获取路径时，获取到的路径被URLEncoder.encode(path,"utf-8")编码了，
             * 当路径中存在中文和空格时，他会对这些字符进行转换，这样，得到的往往不是我们想要的真实路径，
             * 所以我们可以调用URLDecoder.decode()方法进行解码，以便得到原始的中文及空格路径。
             */
            decodePath = URLDecoder.decode(FileOutputStreamExample.class.getClassLoader().getResource("disk/example.txt").getPath(), "UTF-8");
            System.out.println("这是获取到的解码后的文件URL：" + decodePath);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        File file = new File(decodePath);
        String content = "i am 一段文本";

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ByteArrayInputStream bais = new ByteArrayInputStream(content.getBytes());
        ) {
            byte[] temp = new byte[1024];
            int i = 0;
            while ((i = bais.read(temp)) > -1) {
                fileOutputStream.write(temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
