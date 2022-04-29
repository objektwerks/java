package objektwerks;

import org.junit.jupiter.api.Test;

class MathTest {
    int add(int x, int y) {
        return x + y;
    }

    int subtract(int x, int y) {
        return x - y;
    }

    int multiply(int x, int y) {
        return x * y;
    }

    int divide(int x, int y) {
        return x / y;
    }

    boolean isEven(int n) {
        return n  % 2 == 0;
    }

    boolean isOdd(int n) {
        return n  % 2 != 0;
    }

    @Test
    void mathTest() {
        int x = 20;
        int y = 10;
        assert(add(x, y) == 30);
        assert(subtract(x, y) == 10);
        assert(multiply(x, y) == 200);
        assert(divide(x, y) == 2);
        assert(isEven(x));
        assert(isEven(y));
        assert(!isOdd(x));
        assert(!isOdd(y));

        int square = 2;
        assert(Math.pow(square, 2) == 4);

        assert(Math.random() != 0.0);
    }
}