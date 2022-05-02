package objektwerks;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

class Person implements Comparable<Person> {  // old school class, not a record
    private final String first;
    private final String last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Person that = (Person) other;
        return first.equals(that.first) && last.equals(that.last);
    }

    @Override public int compareTo(Person other) {
        return this.last.compareTo(other.last);
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

    @Test void objectsTest() {
        var fred = new Person("fred", "flintstone");
        var fredCopy = new Person("fred", "flintstone");
        var barney = new Person("barney", "rebel");

        assert(fred.equals(fredCopy));
        assert(Objects.equals(fred, fredCopy));
        assert(Objects.deepEquals(fred, fredCopy));

        assert(!fred.equals(barney));
    }

    @Test void comparatorTest() {
        var fred = new Person("fred", "flintstone");
        var barney = new Person("barney", "rebel");
        var persons = List.of(fred, barney);
        var sortedPersons = persons.stream().sorted();
        assert(sortedPersons.toList().get(0).equals(fred));
    }
}