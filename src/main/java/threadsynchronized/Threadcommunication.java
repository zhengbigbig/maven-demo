package threadsynchronized;

public class Threadcommunication {
    // 仓库
    int n;
    boolean valueSet = false;

    // 消费者
    synchronized int get() {
        // value 还没有被设置好
        if (!valueSet)
            try {
                wait(); // 暂停,等待着put()来设置好这个值后再读取
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        System.out.println("Got: " + n);
        valueSet = false; // 标记已经取走了值
        notify(); // 通知put()可以设置另外一个值了
        return n;
    }

    // 生产者
    synchronized void put(int n) {
        // 如果这个值已经设置好了
        if (valueSet)
            try {
                wait(); // 等待get()把值取走
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        this.n = n; // 设置一个新的值
        valueSet = true; // 标记已经设置好了
        System.out.println("Put: " + n);
        notify(); // 通知线程get() 这个最新的值
    }

}
