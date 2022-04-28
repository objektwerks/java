package objektwerks;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RecursionTest {
    int sum(int[] xs, int acc) {
        if (xs.length == 0) return acc;
        else {
            var from = 1;
            var to = xs.length;
            var head = xs[0];
            var tail = Arrays.copyOfRange(xs, from, to);
            System.out.println("from: " + from);
            System.out.println("to: " + to);
            System.out.println("head: " + head);
            System.out.println("tail: " + Arrays.toString(tail));
            return sum(tail, acc + head);
        }
    }

    @Test void sumTest() {
        int[] xs = {1, 2, 3};
        var sum = sum( xs, 0);
        System.out.println("sum: " + sum);
        assert(sum == 6);
    }
}