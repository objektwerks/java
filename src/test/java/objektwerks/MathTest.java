package objektwerks;

import org.junit.jupiter.api.Test;

class MathTest {
    int add(int x, int y) {
        return x + y;
    }

    int subtract(int x, int y) {
        return x - y;
    }

    @Test
    void mathTest() {
        int x = 20;
        int y = 10;
        assert(add(x, y) == 30);
        assert(subtract(x, y) == 10);
        assert(x * y == 200);
        assert(x / y == 2);
        assert(x % 2 == 0 && y % 2 == 0);

        int square = 2;
        assert(Math.pow(square, 2) == 4);

        assert(Math.random() != 0.0);
    }
}