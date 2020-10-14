package dome5;

import java.util.concurrent.CountDownLatch;

public class WaitingTask implements Runnable{
    private static int count=0;
    private final int id=count++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passer for"+this);
        } catch (InterruptedException e) {
            System.out.println(this+"interrupted");
        }
    }

    @Override
    public String toString() {
        return "WaitingTask{" +
                "id=" + id +
                ", latch=" + latch +
                '}';
    }
}
