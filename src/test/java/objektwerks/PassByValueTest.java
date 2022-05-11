package objektwerks;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * <a href="https://www.baeldung.com/java-pass-by-value-or-pass-by-reference">Java Pass By Value</a>
 * 1. For Primitive types, parameters are pass-by-value.
 * 2. For Object types, the object reference is pass-by-value.
 */
class PassByValueTest {
    int square(int i) { // passed by value as primitive
        return i * i; // returns new primitive by value
    }

    String join(String... values) { // passed by value as references
        return Stream
                .of(values)
                .reduce(String::concat)
                .orElse(""); // returns pass by value reference to new String
    }

    @Test void primitiveTest() {
        int i = 2;
        assert(square(i) == 4);
    }

    @Test void objectTest() {
        var joined = join("a", "b", "c");
        assert(joined.equals("abc"));
    }
}