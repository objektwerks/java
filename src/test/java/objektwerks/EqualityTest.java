package objektwerks;

import org.junit.jupiter.api.Test;

class Person {  // old school class, not a record
    private final String first;
    private final String last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return first.equals(that.first) && last.equals(that.last);
    }
}

class EqualityTest {
    @Test void primitive() {
        assert(1 == 1);
    }

    @Test void wrapper() {
        var x = Integer.valueOf(1);
        var y = Integer.valueOf(1);
        var z = new Integer(1);

        // the jvm cached x and reused it for y via Integer.valueOf; hence the structural equality
        assert(x == y);

        // x and z are tested for reference (or memory location) equality; hence the inequality
        assert(x != z);

        // structural equality via equals
        assert(x.equals(y));
        assert(x.equals(z));
    }

    @Test void objectTest() {
        var fred = new Person("fred", "flintstone");
        var barney = new Person("barney", "rebel");
        assert(!fred.equals(barney));
        assert(fred.equals(new Person("fred", "flintstone")));
    }
}