package com.company.spider.multithreads;

public class MainThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread(); // 获取当前线程对象！ 这里是主线程!
        // Java 语言语法层面，线程就是一个Thread类的对象！
        System.out.println("current thread: " + t);

        t.setName("my thread");
        System.out.println("thread id: " + t.getId());
        System.out.println("after name change:" + t);
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted");
        }
    }
}
