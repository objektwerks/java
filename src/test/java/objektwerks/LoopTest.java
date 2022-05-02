package objektwerks;

import org.junit.jupiter.api.Test;

import java.util.List;

class LoopTest {
    @Test void forTest() {
        int[] xs = {1, 2, 3};
        int sum = 0;
        for(int i = 0; i < xs.length; i++) {
          sum += xs[i];
        }
        assert(sum == 6);
    }

    @Test void enhancedForTest() {
        int[] xs = {1, 2, 3};
        int sum = 0;
        for (int x : xs) {  
            sum += x;
        }
        assert(sum == 6);
    }

    @Test void iteratorTest() {
        var xs = List.of(1, 2, 3);
        var iterator = xs.iterator();
        while (iterator.hasNext()) {
            assert(iterator.next() > 0);
        }
    }

    @Test void whileTest() {
        int i = 0;
        while (i < 10) {
            i++;
            assert(i > 0);
        }
    }

    @Test void doWhileTest() {
        int i = 0;
        do {
            i++;
            assert(i > 0);
        } while (i < 10);
    }
}