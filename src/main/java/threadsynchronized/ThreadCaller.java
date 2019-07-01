package threadsynchronized;

public class ThreadCaller implements Runnable {
    ThreadCommunication tc;
    Thread t;

    public ThreadCaller(ThreadCommunication target) {
        tc = target;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        tc.get();
    }
}
