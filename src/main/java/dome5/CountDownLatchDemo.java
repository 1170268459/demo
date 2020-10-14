package dome5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    static final int size=100;

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        CountDownLatch latch=new CountDownLatch(size);
        for (int i = 0; i <10; i++) {
                executorService.execute(new WaitingTask(latch));
        }
        for (int i = 0; i <size ; i++) {
            executorService.execute(new TaskPortion(latch));
        }
        System.out.println("launched all tasks");
        executorService.shutdown();
    }
}
