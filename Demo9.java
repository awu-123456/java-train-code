import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo9 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,60L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100),
                                                             Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        for(int i = 0;i < 200;i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "正在执行任务" + taskId);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
     executor.shutdown();
    }
}
