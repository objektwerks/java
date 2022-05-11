package objektwerks;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
}