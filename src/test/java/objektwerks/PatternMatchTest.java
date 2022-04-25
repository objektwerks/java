package objektwerks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 * This test passes with Maven but fails with Gradle. Fix unknown at this time.
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
        System.out.println("*** " + matchNumber(1));
        System.out.println("*** " + matchNumber(2.0));
        assertEquals(matchNumber(1), "1");
        assertEquals(matchNumber(2.0), "2.0");
    }
}