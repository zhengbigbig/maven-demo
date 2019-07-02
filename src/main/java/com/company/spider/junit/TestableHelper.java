package com.company.spider.junit;

import java.io.*;
public class TestableHelper {
    public static void copy(InputStream input, File des)  throws IOException{

        OutputStream out = new BufferedOutputStream(new FileOutputStream(des));
        byte[] buf = new byte[512];
        int ch;
        try {
            while ((ch = input.read(buf)) != -1) {
                out.write(buf, 0, ch);
            }
        }catch (IOException e){
            throw new IOException("读/写出错");
        }
    }
}
