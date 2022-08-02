package EXE2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    private final ExecutorService pool;

    public ThreadPool(int poolSize){
        pool = Executors.newFixedThreadPool(poolSize);
    }

    public ExecutorService getPool() {
        return pool;
    }

    public void shutDown(){
        pool.shutdown();
    }

    public void awaitTermination(){

        try {
            pool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
