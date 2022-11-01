package objektwerks;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

class VirtualThreadTest {
    @Test void virtualThreadTest() throws ExecutionException, InterruptedException {
        var tasks = new ArrayList<FileLineCountTask>();
        tasks.add( new FileLineCountTask("./data/data.a.csv") );
        tasks.add( new FileLineCountTask("./data/data.b.csv") );

        int sum = 0;
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var futures = executor.invokeAll(tasks);
            for (Future<Integer> future : futures) {
                sum += future.get();
            }
        }
        assert(540959 == sum);
    }
}