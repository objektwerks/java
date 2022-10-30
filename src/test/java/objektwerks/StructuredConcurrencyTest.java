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
    Long handle() throws ExecutionException, InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<Long> factorial  = scope.fork(() -> new FactorialTask(50).call());
            Future<Long> fibonacci = scope.fork(() -> new FibonacciTask(50).call());

            scope.join();
            scope.throwIfFailed();

            return factorial.get() + fibonacci.get();
        }
    }

    @Test void structuredConcurrencyTest() throws ExecutionException, InterruptedException {
        var sum = handle();
        System.out.println("sum: " + Math.abs(sum));
        assert(298632863 == Math.abs(sum));
    }
}