package objektwerks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * This test passes with Maven but fails with Gradle. Fix unknown at this time.
 * Intellij understands this code but VS Code does not.
 */
class PatternMatchTest {
    String mathOn(Number number) {
        return switch (number) {
            case Integer i -> i.toString();
            case Long    l -> l.toString();
            case Double  d -> d.toString();
            case Float   f -> f.toString();
            default        -> "";
        };
    }

    @Test void matchTest() {
        assertEquals(mathOn(1), "1");
        assertEquals(mathOn(2.0), "2.0");
    }
}