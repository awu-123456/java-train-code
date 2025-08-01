class MyBlockingQueue {
    private String[] data;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    public static Object locker = new Object();
    public MyBlockingQueue(int capacity) {
        data = new String[capacity];
    }
    public void put(String elem) throws InterruptedException {
        synchronized (locker) {
            while (size == data.length) {
                locker.wait();
            }
            data[tail] = elem;
            tail++;
            if(tail > data.length) {
                tail = 0;
            }
            size++;
            locker.notify();
        }
    }
    public String take() throws InterruptedException {
        synchronized (locker) {
            while (size == 0) {
                locker.wait();
            }
            String ret = data[head];
            head++;
            if(head >= data.length) {
                head = 0;
            }
            size--;
            locker.notify();
            return ret;
        }
    }
}

public class Demo3 {

}
