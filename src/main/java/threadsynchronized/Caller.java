package threadsynchronized;

public class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        // 这里传入的对象，是被共享的
        synchronized (target){
            target.call(msg);
        }
    }
}
