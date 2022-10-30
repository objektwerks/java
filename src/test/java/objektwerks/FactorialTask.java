package objektwerks;

import java.util.concurrent.Callable;

class FactorialTask implements Callable<Long> {
    int n;

    long factorial(int n, int acc) {
        if (n < 1) return acc;
        else return factorial(n - 1, acc * n);
    }

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    public Long call() {
        return factorial(n, 1);
    }
}
