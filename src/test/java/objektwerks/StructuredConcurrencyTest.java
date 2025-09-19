package objektwerks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

import org.junit.jupiter.api.Test;

class StructuredConcurrencyTest {
    @Test void structuredConcurrencyTest() throws ExecutionException, InterruptedException {
        int lines;
        try (var scope = StructuredTaskScope.open()) {
            var alines = scope.fork(() -> new FileLineCountTask("./data/data.a.csv").call());
            var blines = scope.fork(() -> new FileLineCountTask("./data/data.b.csv").call());
            scope.join();
            lines = alines.get() + blines.get();
        }
        assert(lines == 540_959);
    }
}