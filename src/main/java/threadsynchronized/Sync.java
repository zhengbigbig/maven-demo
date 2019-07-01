package threadsynchronized;

public class Sync {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World");
        // wait for threads to end
        // join 线程的合并的含义就是 将几个并行线程的线程合并为一个单线程执行
        // 应用场景是 当一个线程必须等待另一个线程执行完毕才能执行时，Thread类提供了join方法来完成这个功能
        ThreadCommunication tc = new ThreadCommunication();
        ThreadCallMe tcm = new ThreadCallMe(tc,10);
        ThreadCaller tcr = new ThreadCaller(tc);
        try {
            ob1.t.join();  // 线程合并
            ob2.t.join();
            ob3.t.join();
            tcm.t.join();
            tcr.t.join();

        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
