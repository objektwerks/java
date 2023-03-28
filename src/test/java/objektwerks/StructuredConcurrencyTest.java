package objektwerks;

import jdk.incubator.concurrent.StructuredTaskScope;
import jdk.incubator.concurrent.ScopedValue;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

/**
 * Run > Edit Configurations > StructuredConcurrencyTest
 * --enable-preview --add-modules jdk.incubator.concurrent
 * Structured Concurrency: openjdk.org/jeps/428
 * ScopedValue: openjdk.org/jeps/429 ( TODO )
 */
class StructuredConcurrencyTest {
    private static final String uuid = UUID.randomUUID().toString();
    private static final ScopedValue<String> license = ScopedValue.newInstance();

    @Test void scopedValueTest() throws Exception {
        Integer lines = ScopedValue
                            .where(license, uuid)
                            .call( new FileLineCountTask("./data/data.a.csv") );
        assert(lines == 270562);
        assert(!license.isBound());
    }

    @Test void structuredConcurrencyTest() throws ExecutionException, InterruptedException {
        int lines;
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<Integer> alines = scope.fork(() -> new FileLineCountTask("./data/data.a.csv").call());
            Future<Integer> blines = scope.fork(() -> new FileLineCountTask("./data/data.b.csv").call());
            scope.join();
            scope.throwIfFailed();
            lines = alines.resultNow() + blines.resultNow();
        }
        assert(lines == 540_959);
    }
}