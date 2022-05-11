package objektwerks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class CustomException extends Exception {
    CustomException(String message) {
        super(message);
    }
}

/**
 * See <a href="https://www.baeldung.com/java-exceptions">Java Exceptions</a>
 */
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

    @Test void customTest() {
        assertThrows(CustomException.class, () -> {
            if (new Random().nextInt() != 0) throw new CustomException("int != 0");
        });
    }
}