package com.company.spider.threaddemo2;

import java.io.*;

public class ThreadWrite extends Thread {
    int i;
    String content;

    public ThreadWrite(String content, int i) {
        super();
        this.content = content;
        this.i = i;
        start();
    }

    @Override
    public void run() {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(i + ".txt"), "UTF-8");
            System.out.println("写入" + this.content);
            writer.write(this.content);
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace(); // 在命令行打印异常信息在程序中出错的位置及原因
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = 1;
        while (true) {
            ThreadWrite w = new ThreadWrite(reader.readLine(), i);
            i++;
        }
    }
}
