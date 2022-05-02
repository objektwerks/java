package objektwerks;

import java.util.*;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

enum Level {
    high,
    medium,
    low;

    int toInt() {
        return switch(this) {
            case high -> 1;
            case medium -> 2;
            case low -> 3;
        };
    }
}

class CollectionTest {
    @Test void enumTest() {
        var high = Level.high;
        assert(high.toString().equals("high"));
        assert(Level.valueOf("high") == high);

        assert(Level.values().length == 3);
        for (Level level : Level.values()) {
            assert(!level.name().isEmpty());
        }

        assert(Level.high.toInt() == 1);
        assert(Level.medium.toInt() == 2);
        assert(Level.low.toInt() == 3);
    }

    @Test void enumSetTest() {
        var enumSet = EnumSet.of(Level.high, Level.medium, Level.low);
        assert(enumSet.size() == 3);
        assert(enumSet.contains(Level.high));
        assert(enumSet.contains(Level.medium));
        assert(enumSet.contains(Level.low));
    }

    @Test void enumMapTest() {
        var enumMap = new EnumMap<Level, Integer>(Level.class);
        enumMap.put(Level.high, 1);
        enumMap.put(Level.medium, 2);
        enumMap.put(Level.low, 3);
        assert(enumMap.size() == 3);
        assert(enumMap.get(Level.high) == 1);
        assert(enumMap.get(Level.medium) == 2);
        assert(enumMap.get(Level.low) == 3);
    }

    public int add(Integer... zeroOrMoreIntegers) {
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
    }

    @Test void immutableListTest() {
        var immutableList = List.of(1, 2, 3);
        assert(immutableList.size() == 3);
        assert(immutableList.get(0) == 1);
    }

    @Test void mutableListTest() {
        var mutableList = new ArrayList<Integer>();
        mutableList.add(1);
        mutableList.add(2);
        mutableList.add(3);
        assert(mutableList.add(4));
        assert(mutableList.remove(3) == 4);
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