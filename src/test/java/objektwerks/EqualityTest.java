package objektwerks;

import org.junit.jupiter.api.Test;

class EqualityTest {
    @Test void primitive() {
        assert(1 == 1);
    }

    @Test void wrapper() {
        var x = Integer.valueOf(1);
        var y = Integer.valueOf(1);
        var z = new Integer(1);

        // the jvm cached x and reused it for y via Integer.valueOf; hence the structural equality
        assert(x == y);

        // x and z are tested for reference (or memory location) equality; hence the inequality
        assert(x != z);

        // structural equality via equals
        assert(x.equals(y));
        assert(x.equals(z));
    }
}