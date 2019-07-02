package com.company.spider.junit;

import java.io.*;

public class Helper {
    public static void copy(File A, File B) throws IOException {
        InputStream input = new BufferedInputStream(new FileInputStream(A));
        OutputStream output = new BufferedOutputStream(new FileOutputStream(B));

        byte[] buf = new byte[512];
        int ch;
        try {
            while ((ch = input.read(buf)) != -1){
                output.write(buf,0,ch);
            }
        }finally {
            input.close();
            output.close();
        }

    }
}
