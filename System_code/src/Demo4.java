import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo4 {
    public static void main(String[] args) {
        //ExecutorService executorService1 = Executors.newFixedThreadPool(6);
        //ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        //ExecutorService executorService3 = Executors.newScheduledThreadPool(6);
        //ExecutorService executorService4 = Executors.newWorkStealingPool();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i < 1000;i++) {
            final int id = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String name = Thread.currentThread().getName();
                    System.out.println("hello "+name+","+id);
                }
            });
        }
    }
}
