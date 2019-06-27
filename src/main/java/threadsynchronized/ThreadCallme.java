package threadsynchronized;

public class ThreadCallme implements Runnable {
    Threadcommunication tc;
    int num;
    Thread t;

    public ThreadCallme(Threadcommunication target,int n) {
        tc = target;
        num = n;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        tc.put(num);
    }
}

