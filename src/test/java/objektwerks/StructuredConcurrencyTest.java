package objektwerks;

import jdk.incubator.concurrent.StructuredTaskScope;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

/**
 * Run > Edit Configurations > StructuredConcurrencyTest
 * --enable-preview --add-modules jdk.incubator.concurrent
 *
 * Structured Concurrency: https://openjdk.org/jeps/428
 */
class StructuredConcurrencyTest {
    @Test void structuredConcurrencyTest() throws ExecutionException, InterruptedException {
        int sum = 0;
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<Integer> factorial  = scope.fork(() -> new FileLineCountTask("./data/data.a.csv").call());
            Future<Integer> fibonacci = scope.fork(() -> new FileLineCountTask("./data/data.b.csv").call());
            scope.join();
            scope.throwIfFailed();
            sum = factorial.get() + fibonacci.get();
        }
        assert(sum == 540959);
    }
}