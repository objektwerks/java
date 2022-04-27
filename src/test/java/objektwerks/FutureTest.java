package objektwerks;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FutureTest {
    public Future<String> helloFuture() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(1000);
            completableFuture.complete("Hello, future!");
            return null;
        });
        return completableFuture;
    }

    @Test void completableFutureTest() throws InterruptedException, ExecutionException {
        Future<String> completableFuture = helloFuture();
        String result = completableFuture.get();
        assertEquals("Hello, future!", result);
    }
}