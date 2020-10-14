package dome12;

import java.util.concurrent.*;

public class ThreadPoolSize {

    private static final int CORE =5;

    private static final int MAX_NUMBER=10;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE, MAX_NUMBER, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i <100 ; i++) {
            threadPoolExecutor.execute(new ThreadStudy(i));

        }
        threadPoolExecutor.shutdown();
    }
}
