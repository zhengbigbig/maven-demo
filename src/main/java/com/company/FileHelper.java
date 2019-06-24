package com.company;
import java.io.*;

public class FileHelper {
    public static void copy(File name1,File name2) throws IOException {
        name2.writeString(name1.readToString());
    }
}
