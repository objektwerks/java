package objektwerks;

import org.junit.jupiter.api.Test;

class EqualityTest {
    @Test void primitive() {
        assert(1 == 1);
    }

    @Test void wrapper() {
        var x = Integer.valueOf(1);
        var y = Integer.valueOf(1);
        assert(x == y); // unboxes integer to int; hence the equality
        assert(x.equals(y));
    }
}