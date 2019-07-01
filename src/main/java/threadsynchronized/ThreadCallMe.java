package threadsynchronized;

public class ThreadCallMe implements Runnable {
    ThreadCommunication tc;
    int num;
    Thread t;

    public ThreadCallMe(ThreadCommunication target, int n) {
        tc = target;
        num = n;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        tc.put(num);
    }
}

