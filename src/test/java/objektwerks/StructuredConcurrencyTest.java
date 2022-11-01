package objektwerks;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import jdk.incubator.concurrent.StructuredTaskScope;

import org.junit.jupiter.api.Test;

/**
 * Run > Edit Configurations > StructuredConcurrencyTest
 * --enable-preview --add-modules jdk.incubator.concurrent
 */
class StructuredConcurrencyTest {
    Integer handle() throws ExecutionException, InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<Integer> factorial  = scope.fork(() -> new FileLineCountTask("./data/data.a.csv").call());
            Future<Integer> fibonacci = scope.fork(() -> new FileLineCountTask("./data/data.b.csv").call());

            scope.join();
            scope.throwIfFailed();

            return factorial.get() + fibonacci.get();
        }
    }

    @Test void structuredConcurrencyTest() throws ExecutionException, InterruptedException {
        assert(540959 == handle());
    }
}