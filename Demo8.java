import java.util.concurrent.CountDownLatch;

public class Demo8 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(8);
        for(int i = 0;i < 8;i++) {
            int id = i;
            Thread t = new Thread(() -> {
                System.out.println("运动员"+id+"开始");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("运动员"+id+"到达终点");
                latch.countDown();
            });
            t.start();
        }
        latch.await();
        System.out.println("比赛结束");
    }
}
