package objektwerks;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

/**
 * Virtual Threads: openjdk.org/jeps/425
 */
class VirtualThreadTest {
    @Test void virtualThreadTest() throws ExecutionException, InterruptedException {
        var tasks = new ArrayList<FileLineCountTask>(2);
        tasks.add( new FileLineCountTask("./data/data.a.csv") );
        tasks.add( new FileLineCountTask("./data/data.b.csv") );

        int lines = 0;
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var futures = executor.invokeAll(tasks);
            for (var future : futures) {
                lines += future.get();
            }
        }
        assert(lines == 540_959);
    }
}