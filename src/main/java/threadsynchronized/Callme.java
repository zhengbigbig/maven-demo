package threadsynchronized;

public class Callme {
    void call(String msg) {
        System.out.println("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}
