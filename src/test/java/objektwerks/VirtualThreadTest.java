package objektwerks;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

/**
 * <a href="https://openjdk.org/jeps/425">Virtual Threads</a>
 */
class VirtualThreadTest {
    @Test void virtualThreadTest() throws ExecutionException, InterruptedException {
        var tasks = new ArrayList<FileLineCountTask>();
        tasks.add( new FileLineCountTask("./data/data.a.csv") );
        tasks.add( new FileLineCountTask("./data/data.b.csv") );

        int sum = 0;
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var futures = executor.invokeAll(tasks);
            for (var future : futures) {
                sum += future.get();
            }
        }
        assert(sum == 540959);
    }
}