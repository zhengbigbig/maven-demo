package com.company.spider.threaddemo;

public class MultiThreads extends Thread {
    private String content;

    MultiThreads(String name, String content) {
        super(name);
        this.content = content;
        start();
    }

    public void run() {
        try {
            for (int i = 0; i < content.length(); i++) {
                System.out.println(content.charAt(i));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }

    public static void main(String[] args) {
        MultiThreads t1 = new MultiThreads("Child1", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        MultiThreads t2 = new MultiThreads("Child2", "abcdefghijklmnopqrstuvwxyz");
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(i + 1);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted");
        }
    }
}
