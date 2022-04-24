package objektwerks;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CollectionTest {
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

    @Test void arrayListTest() {
        int[] xs = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : xs) {
          list.add(x);
        }
        assert(list.size() == 3);
    }
}