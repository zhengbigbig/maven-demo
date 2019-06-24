package com.company;

import java.io.*;
import java.io.File;

public class FileNews extends News {
    public FileNews(String title, String content) {
        super(title, content);
    }

    public FileNews() {
    }

    public void read(String url) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(url)));
            title = reader.readLine();  //读取title
            reader.readLine(); // 跳过空行
            content = reader.readLine(); //读取content
        } catch (IOException e) {
            System.out.println("出错");
        }
    }
}
