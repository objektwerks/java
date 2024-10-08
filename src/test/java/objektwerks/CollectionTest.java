package objektwerks;

import java.util.*;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class CollectionTest {
    int add(Integer... zeroOrMoreIntegers) {
        return Stream
            .of(zeroOrMoreIntegers)
            .reduce(Integer::sum)
            .orElse(-1);
    }

    @Test void varargsTest() {
        assert(add(1, 2, 3) == 6);
    }

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
        var ys = new ArrayList<>();
        for (int x : xs) {
          ys.add(x);
        }
        assert(ys.size() == 3);
        assert(ys.get(0).equals(1));
        assert(ys.contains(3));
        assert(ys.indexOf(1) == 0);
    }

    @Test void immutableListTest() {
        var immutableList = List.of(1, 2, 3);
        assert(immutableList.size() == 3);
        assert(immutableList.get(0) == 1);
        assert(immutableList.contains(3));
        assert(immutableList.indexOf(1) == 0);
    }

    @Test void mutableListTest() {
        var mutableList = new ArrayList<Integer>();
        mutableList.add(1);
        mutableList.add(2);
        mutableList.add(3);
        assert(mutableList.add(4));
        assert(mutableList.remove(3) == 4);
        assert(mutableList.get(0) == 1);
        assert(mutableList.contains(3));
        assert(mutableList.indexOf(1) == 0);
    }

    @Test void setTest() {
        var set = Set.of(1, 2, 3);
        assert(set.size() == 3);
        assert(set.contains(1));
        assert(set.contains(2));
        assert(set.contains(3));
    }

    @Test void sortedSetTest() {
        var set = new TreeSet<Integer>();
        set.add(3);
        set.add(2);
        set.add(1);
        assert(set.size() == 3);
        assert(set.first() == 1);
        assert(set.last() == 3);
    }

    @Test void mapTest() {
        var map = Map.of(1, 1, 2, 2, 3, 3);
        assert(map.size() == 3 );
        assert(map.get(1) == 1);
        assert(map.get(2) == 2);
        assert(map.get(3) == 3);
    }

    @Test void sortedMapTest() {
        var map = new TreeMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        assert(map.size() == 3);
        assert(map.firstKey() == 1);
        assert(map.lastKey() == 3);
    }
}