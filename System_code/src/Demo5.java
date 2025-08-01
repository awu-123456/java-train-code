import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class MyThreadPool {
    private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
    public MyThreadPool(int n) {
        for(int i = 0;i < n;i++) {
            Thread t = new Thread(() -> {
                try {
                    while(true) {
                        Runnable task = queue.take();
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.setDaemon(true);
            t.start();
        }
    }
    public void submit(Runnable task) throws InterruptedException {
        queue.put(task);
    }
}
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool =  new MyThreadPool(4);
        for(int i = 0;i < 1000;i++) {
            int id = i;
            pool.submit(() -> {
                Thread cur = Thread.currentThread();
                System.out.println("hello"+cur.getName()+","+id);
            });
        }
        Thread.sleep(1000);
    }
}
