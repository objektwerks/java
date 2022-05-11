package objektwerks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ExceptionTest {
    @Test void checkedTest() {
        assertThrows(IOException.class, () -> {
            var path = Paths.get("build.gradle");
            var lines = Files.readAllLines(path);
            assert(!lines.isEmpty());
        });
    }

    @Test void uncheckedTest() {
        assertThrows(NumberFormatException.class, () -> {
            var i = Integer.parseInt("one");
            assert(i == 1);
        });
    }

    @Test void tryCatchTest() {
        var i = 0;
        try {
            i = Integer.parseInt("one");
        } catch (NumberFormatException exception) {
            i = -1;
        }
        assert(i == -1);
    }
}