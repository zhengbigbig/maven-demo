package com.company.spider.multithreads;


// 自定义的线程类 NewThread
// 运行的代码逻辑和main() (主线程)不同
public class NewThread extends Thread {
    NewThread() {
        // create a new,second thread
        super("Demo Thread");
        System.out.println("Child thread: " + this);
        // 显式地开始执行这个线程！ --> 做一些基本的初始化操作 --> run()
        start(); // Start the thread
    }

    // This is the entry point for the second thread.
    // new thread entry
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread");
    }

    // 主线程逻辑
    public static void main(String[] args) {
        // 创建新的子线程！
        new NewThread(); // create a new thread
        // 调用完构造方法，start()之后，子线程开始执行，主线程返回到main()方法，继续执行下面的代码
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }

}
