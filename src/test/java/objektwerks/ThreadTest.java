package objektwerks;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreadTest {
    @Test void threadTest() throws InterruptedException {
        var counter = new AtomicInteger(0);
        var thread = new Thread(
            () -> {
                counter.set(1);
                assert(counter.get() == 1);
            });
        thread.start();
        thread.join();
    }

    @Test void executorTest() {
        var counter = new AtomicInteger(0);
        try (var executor = Executors.newSingleThreadExecutor()) {
            executor.execute(
                    () -> {
                        counter.set(1);
                        assert (counter.get() == 1);
                    }
            );
        }
    }

    @Test void executorServiceTest() throws ExecutionException, InterruptedException, TimeoutException {
        var counter = new AtomicInteger(0);
        Future<Integer> future;
        try (var executor = Executors.newFixedThreadPool(2)) {
            future = executor.submit(
                    () -> {
                        counter.set(1);
                        return counter.get();
                    }
            );
        }
        var result = future.get(100, TimeUnit.MILLISECONDS);
        assertEquals(Integer.valueOf(1), result);
    }

    @Test void scheduledExecutorServiceTest() throws ExecutionException, InterruptedException, TimeoutException {
        var counter = new AtomicInteger(0);
        var result = 0;
        try (var executor = Executors.newScheduledThreadPool(2)) {
            var future = executor.schedule(
                    () -> {
                        counter.set(1);
                        return counter.get();
                    },
                    100,
                    TimeUnit.MILLISECONDS
            );
            result = future.get(300, TimeUnit.MILLISECONDS);
        }

        assertEquals(Integer.valueOf(1), result);
    }

    @Test void threadPoolExecutorTest() throws ExecutionException, InterruptedException, TimeoutException {
        var counter = new AtomicInteger(0);
        var result = 0;
        try (var executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2)) {
            var future = executor.submit(
                    () -> {
                        counter.set(1);
                        return counter.get();
                    }
            );
            result = future.get(100, TimeUnit.MILLISECONDS);
        }
        assertEquals(Integer.valueOf(1), result);
    }

    @Test void completableFutureTest() throws InterruptedException, ExecutionException {
        var future = CompletableFuture.supplyAsync(() -> "Hello, future!");
        assertEquals("Hello, future!", future.get());
    }

    @Test void composeFuturesTest() throws ExecutionException, InterruptedException {
        var future = CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenCompose(hello -> CompletableFuture.supplyAsync(() -> hello + ", future!"));
        assertEquals("Hello, future!", future.get());
    }
}