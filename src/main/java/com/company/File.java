package com.company;

import java.io.*;

public class File {
    private String file;

    public File(String file) {
        this.file = file;
    }

    public String readToString() throws IOException {
        CharArrayWriter writer = new CharArrayWriter();
        InputStreamReader reader =
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(this.file)), "UTF-8");
        char[] charArr = new char[512];
        int readChars;
        String ret;

        try {
            while ((readChars = reader.read(charArr)) != -1) {
                writer.write(charArr, 0, readChars);
            }
            ret = writer.toString();
        }finally {
            reader.close();
            writer.close();
        }

        return ret;
    }
    public void writeString(String content)throws IOException{
        PrintWriter writer = new PrintWriter(this.file);
        try {
            writer.print(content);
        }finally {
            writer.close();
        }
    }
}
