package objektwerks;

import java.util.EnumMap;
import java.util.EnumSet;

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

enum Singleton {
    INSTANCE;

    int square(int i) {
        return i * i;
    }
}

class EnumTest {
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

    @Test void singletonTest() {
        assert(Singleton.INSTANCE.square(2) == 4);
    }
}