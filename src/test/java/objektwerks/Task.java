package objektwerks;

import java.util.concurrent.Callable;

class Task implements Callable<Long> {
    int n;

    long fibonacci(int n, int a, int b) {
        if (n == 0) return a;
        else return fibonacci(n -1, b, a + b);
    }

    public Task(int n) {
        this.n = n;
    }

    @Override
    public Long call() {
        return fibonacci(n, 0, 1);
    }
}