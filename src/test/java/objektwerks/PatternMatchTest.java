package objektwerks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 * This test passes with Maven but fails with Gradle. Fix unknown at this time.
 * Intellij understands this code but VS Code does not.
 */
class PatternMatchTest {
    String matchNumber(Object number) {
        return switch (number) {
            case Integer i -> i.toString();
            case Double  d -> d.toString();
            default        -> fail("match on number failed!");
        };
    }

    @Test void matchTest() {
        assertEquals(matchNumber(1), "1");
        assertEquals(matchNumber(2.0), "2.0");
    }
}