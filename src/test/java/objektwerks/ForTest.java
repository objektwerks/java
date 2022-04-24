package objektwerks;

import org.junit.jupiter.api.Test;

class ForTest {
    @Test void arrayTest() {
        int[] xs = {1, 2, 3};
        assert(xs.length == 3);
    }

    @Test void forEachTest() {
        int[] xs = {1, 2, 3};
        int sum = 0;
        for (int x : xs) {  
            sum += x;
        }
        assert(sum == 6);
    }
}