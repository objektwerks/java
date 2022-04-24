package objektwerks;

import org.junit.jupiter.api.Test;

class ForTest {
    @Test void forTest() {
        int[] xs = {1, 2, 3};
        int sum = 0;
        for(int i = 0; i < xs.length; i++) {
          sum += xs[i];
        }
        assert(sum == 6);
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