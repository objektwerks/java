package objektwerks;

import org.junit.jupiter.api.Test;

class VirtualThreadTest {
    long fibonacci(long n, long a, long b) {
        if (n == 0) return a;
        else return fibonacci(n -1, b, a + b);
    }

    @Test void virtualThreadTest() {
        assert(fibonacci(39, 0, 1) == 63245986);
    }
}