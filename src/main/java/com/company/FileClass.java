package com.company;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class FileClass {
    private  FileInputStream file;
    private InputStreamReader reader;

    public FileClass(String filename) throws FileNotFoundException {
        this.file = new FileInputStream(filename);

    }
    public InputStreamReader readToString() throws IOException {
        this.reader = new InputStreamReader(this.file,"UTF-8");
        return this.reader;
    }
    public void writeString(String name) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(name);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");
        int ch;
        while ((ch = this.reader.read()) != -1){
            outputStreamWriter.write(ch);
        }
    }
}


