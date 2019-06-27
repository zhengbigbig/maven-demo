package threadsynchronized;

public class ThreadCaller implements Runnable {
    Threadcommunication tc;
    Thread t;

    public ThreadCaller(Threadcommunication target) {
        tc = target;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        tc.get();
    }
}
