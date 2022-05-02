package objektwerks;

import org.junit.jupiter.api.Test;

class EqualityTest {
    @Test void primitive() {
        assert(1 == 1);
    }

    @Test void wrapper() {
        assert(Integer.valueOf(1).equals(Integer.valueOf(1)));
    }
}