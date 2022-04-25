package objektwerks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        ArrayList<Integer> ys = new ArrayList<>();
        for (int x : xs) {
          ys.add(x);
        }
        assert(ys.size() == 3);
    }

    @Test void listTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assert(list.size() == 3);
    }

    @Test void setTest() {
        Set<Integer> set = Set.of(1, 2, 3);
        assert(set.size() == 3);
    }

    @Test void mapTest() {
        Map<Integer, Integer> map = Map.of(1, 1, 2, 2, 3, 3);
        assert(map.size() == 3 );
    }
}