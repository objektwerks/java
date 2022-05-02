package objektwerks;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

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
}