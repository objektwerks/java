package objektwerks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PatternMatchTest {
    String matchOn(Number number) {
        return switch (number) {
            case Integer i -> i.toString();
            case Long    l -> l.toString();
            case Double  d -> d.toString();
            case Float   f -> f.toString();
            default        -> "";
        };
    }

    @Test void matchTest() {
        assertEquals(matchOn(1), "1");
        assertEquals(matchOn(2.0), "2.0");
    }
}