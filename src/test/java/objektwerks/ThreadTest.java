package objektwerks;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreadTest {
    @Test void executorTest() {
        var counter = new AtomicInteger(0);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(
            () -> {
                counter.set(1);
                assert(counter.get() == 1);
            }
        );
    }

    @Test void executorServiceTest() throws ExecutionException, InterruptedException, TimeoutException {
        var counter = new AtomicInteger(0);
        var executor = Executors.newFixedThreadPool(2);
        Future<Integer> future = executor.submit(
            () -> {
                counter.set(1);
                return Integer.valueOf(counter.get());
            }
        );
        var result = future.get(100, TimeUnit.MILLISECONDS);
        assertEquals(Integer.valueOf(1), result);
    }

    @Test void scheduledExecutorServiceTest() throws ExecutionException, InterruptedException, TimeoutException {
        var counter = new AtomicInteger(0);
        var executor = Executors.newScheduledThreadPool(2);
        Future<Integer> future = executor.schedule(
            () -> {
                counter.set(1);
                return Integer.valueOf(counter.get());
            },
            100,
            TimeUnit.MILLISECONDS
        );
        var result = future.get(300, TimeUnit.MILLISECONDS);
        assertEquals(Integer.valueOf(1), result);
    }

    @Test void threadPoolExecutorTest() throws ExecutionException, InterruptedException, TimeoutException {
        var counter = new AtomicInteger(0);
        var executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        Future<Integer> future = executor.submit(
                () -> {
                    counter.set(1);
                    return Integer.valueOf(counter.get());
                }
        );
        var result = future.get(100, TimeUnit.MILLISECONDS);
        assertEquals(Integer.valueOf(1), result);
    }
}