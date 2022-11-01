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

    String matchOn(String string) {
        return switch (string) {
            case String s when s.length() < 1 -> "empty";
            case String s when s.length() < 2 -> "length of 1";
            case String s when s.length() < 3 -> "length of 2";
            case String s when s.length() < 4 -> "length of 3";
            default -> "length greater than 3";
        };
    }


    @Test void matchTest() {
        assertEquals(matchOn(1), "1");
        assertEquals(matchOn(2.0), "2.0");
    }

    @Test void matchWhenTest() {
        assertEquals(matchOn(""), "empty");
        assertEquals(matchOn("a"), "length of 1");
        assertEquals(matchOn("aa"), "length of 2");
        assertEquals(matchOn("aaa"), "length of 3");
        assertEquals(matchOn("aaaa"), "length greater than 3");
    }
}