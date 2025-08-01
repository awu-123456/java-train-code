import java.util.PriorityQueue;

class MyTimerTask implements Comparable<MyTimerTask>{
    private Runnable runnable;
    private long time;
    public MyTimerTask(Runnable runnable,long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }
    public long getTime() {
        return time;
    }
    public void run() {
        runnable.run();
    }
    public int compareTo(MyTimerTask o) {
        return (int)(this.time - o.time);
    }
}
class MyTimer {
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    private Object locker = new Object();
    public MyTimer() {
        Thread t = new Thread(() -> {
            try {
                while(true) {
                    synchronized (locker) {
                        MyTimerTask task = queue.peek();
                        while (task == null) {
                            locker.wait();
                            task = queue.peek();
                        }
                        long curTime = System.currentTimeMillis();
                        if(curTime >= task.getTime()) {
                            task.run();
                            queue.poll();
                        } else {
                            locker.wait(task.getTime() - curTime);
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("wait 被终止");
            }
        });
        t.start();
    }
    public void schedule(Runnable runnable,long delay) {
        synchronized (locker) {
            MyTimerTask task = new MyTimerTask(runnable,delay);
            queue.add(task);
            locker.notify();
        }
    }
}
public class Demo7 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(() -> {
            System.out.println("hello 3000");
        },3000);
        timer.schedule(() -> {
            System.out.println("hello 2000");
        },2000);
        timer.schedule(() -> {
            System.out.println("hello 1000");
        },1000);
    }
}
