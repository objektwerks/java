package objektwerks;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

class VirtualThreadTest {
    @Test void virtualThreadTest() throws ExecutionException, InterruptedException {
        var tasks = new ArrayList<FibonacciTask>();
        for (int i = 0; i < 1000; i++) {
            tasks.add(new FibonacciTask(i));
        }

        long sum = 0;
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var futures = executor.invokeAll(tasks);
            for (Future<Long> future : futures) {
                sum += future.get();
            }
        }
        System.out.println("sum: " + Math.abs(sum));
        assert(84580933396L == Math.abs(sum));
    }
}