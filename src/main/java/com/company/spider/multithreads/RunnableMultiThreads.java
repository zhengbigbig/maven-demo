package com.company.spider.multithreads;

public class RunnableMultiThreads {
    static class NewThread implements Runnable {
        private String name; // name if thread
        // 定义一个私有地Thread对象
        private Thread t;

        NewThread(String threadname) {
            name = threadname;
            // 创建一个Thread对象，将this传递给这个Thread，本质就是为了给它 run()
            System.out.println("this" + this);
            t = new Thread(this, name);
            System.out.println("New Thread: " + t);
            t.start(); // Start the thread
        }

        // This is the entry point for thread.
        public void run() {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);

            }
            System.out.println(name + "exiting.");
        }
    }

    public static void main(String[] args) {
        new NewThread("One");
        new NewThread("Two");
        new NewThread("Three");

    }
}
