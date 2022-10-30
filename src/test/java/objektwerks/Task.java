package objektwerks;

import java.util.concurrent.Callable;

class Task implements Callable<Long> {
    long fibonacci(long n, long a, long b) {
        if (n == 0) return a;
        else return fibonacci(n -1, b, a + b);
    }

    public Task() {
    }

    @Override
    public Long call() {
        return fibonacci(39, 0, 1);
    }
}