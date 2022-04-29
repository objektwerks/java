package objektwerks;

import org.junit.jupiter.api.Test;

class MathTest {
    @Test
    void mathTest() {
        int x = 20;
        int y = 10;

        assert(x + y == 30);
        assert(x - y == 10);
        assert(x * y == 200);
        assert(x / y == 2);
        assert(x % 2 == 0 && y % 2 == 0);

        assert(Math.random() != 0.0);
    }
}