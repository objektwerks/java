package objektwerks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

class EqualityTest {
    @Test void primitive() {
        assert(1 == 1);
    }

    @Test void wrapper() {
        assertFalse(Integer.valueOf(1) == (Integer.valueOf(1)));
        assert(Integer.valueOf(1).equals(Integer.valueOf(1)));
    }
}