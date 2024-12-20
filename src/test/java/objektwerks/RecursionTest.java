package objektwerks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class RecursionTest {
    int sum(int[] xs, int acc) {
        if (xs.length == 0) return acc;
        else {
            var from = 1;
            var to = xs.length;
            var head = xs[0];
            var tail = Arrays.copyOfRange(xs, from, to);
            debug(from, to, head, tail);
            return sum(tail, acc + head);
        }
    }

    @Test void sumTest() {
        int[] xs = {1, 2, 3};
        var sum = sum( xs, 0);
        debug("sum: " + sum);
        assert(sum == 6);
    }

    int product(int[] xs, int acc) {
        if (xs.length == 0) return acc;
        else {
            var from = 1;
            var to = xs.length;
            var head = xs[0];
            var tail = Arrays.copyOfRange(xs, from, to);
            debug(from, to, head, tail);
            return product(tail, acc * head);
        }
    }

    @Test void productTest() {
        int[] xs = {1, 2, 3};
        var product = product( xs, 1);
        debug("product: " + product);
        assert(product == 6);
    }

    List<String> reverse(List<String> strings, List<String> acc) {
        if (strings.isEmpty()) return acc;
        else {
            var from = 1;
            var to = strings.size();
            var head = strings.get(0);
            var tail = strings.subList(from, to);
            debug(from, to, head, tail);
            acc.add(0, head);
            return reverse(tail, acc);
        }
    }

    @Test void reverseTest() {
        var values = new ArrayList<String>();
        values.add("a");
        values.add("b");
        values.add("c");
        var acc = new ArrayList<String>();
        var reversed = reverse(values, acc);
        debug("reversed: " + reversed);
        assert(reversed.equals(List.of("c", "b", "a")));
    }

    int factorial(int n, int acc) {
        if (n < 1) return acc;
        else return factorial(n - 1, acc * n);
    }

    @Test void factorialTest() {
        assert(factorial(3, 1) == 6);
    }

    long nonTailRecFibonacci(long n) {
        if ((n == 0) || (n == 1)) return n;
        else return nonTailRecFibonacci(n - 1) + nonTailRecFibonacci(n - 2);
    }

    long tailRecFibonacci(long n, long a, long b) {
        if (n == 0) return a;
        else return tailRecFibonacci(n -1, b, a + b);
    }

    @Test void fibonacciTest() {
        assert(nonTailRecFibonacci(39) == 63245986);
        assert(tailRecFibonacci(39, 0, 1) == 63245986);
    }

    void debug(int from, int to, int head, int[] tail) {
        System.out.println("from: " + from + " to: " + to);
        System.out.println("head: " + head + " tail: " + Arrays.toString(tail));
    }

    void debug(int from, int to, String head, List<String> tail) {
        System.out.println("from: " + from + " to: " + to);
        System.out.println("head: " + head + " tail: " + tail);
    }

    void debug(String message) {
        System.out.println(message);
    }
}