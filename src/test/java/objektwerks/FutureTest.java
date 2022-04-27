package objektwerks;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FutureTest {
    @Test void completableFutureTest() throws InterruptedException, ExecutionException {
        var future = CompletableFuture.supplyAsync(() -> "Hello, future!");
        var result = future.get();
        assertEquals("Hello, future!", result);
    }
}