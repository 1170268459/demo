package dome5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TaskPortion implements Runnable {
    private static int count=0;

    private final int id=count++;

    private static Random rand=new Random(47);

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    private final CountDownLatch latch;
    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
    }

    @Override
    public String toString() {
        return "TaskPortion{" +
                "id=" + id +
                ", latch=" + latch +
                '}';
    }
}
