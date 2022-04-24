package objektwerks;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ForTest {
    @Test void arrayTest() {
        int[] xs = {1, 2, 3};
        assert(xs.length == 3);

        int[] ys = new int[3];
        ys[0] = 1; 
        ys[1] = 2;
        ys[2] = 3;
        assert(ys.length == 3);

        assert(xs != ys); // reference equality
        assert(Arrays.equals(xs, ys)); // structural equality
    }

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