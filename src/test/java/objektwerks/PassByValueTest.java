package objektwerks;

import org.junit.jupiter.api.Test;

/**
 * <a href="https://www.baeldung.com/java-pass-by-value-or-pass-by-reference">Java Pass By Value</a>
 * 1. For Primitive types, parameters are pass-by-value.
 * 2. For Object types, the object reference is pass-by-value.
 */
class PassByValueTest {
    int square(int i) {
        return i * i; // returns new primitive by value
    }

    @Test void primitiveTest() {
        int i = 2;
        assert(square(i) == 4);
    }

    @Test void objectTest() {

    }
}