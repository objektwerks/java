package objektwerks;

import java.util.Objects;

import org.junit.jupiter.api.Test;

class Person implements Comparable<Person> {
    private final String first;
    private final String last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String first() {
        return first;
    }

    public String last() {
        return last;
    }

    @Override public int hashCode() {
        return first.hashCode() + last.hashCode();
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

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}

class EqualityTest {
    @Test void primitiveTest() {
        assert(1 == 1);
    }

    @Test void wrapperTest() {
        var x = Integer.valueOf(1);
        var y = Integer.valueOf(1);

        // the jvm cached x and reused it for y via Integer.valueOf;
        // hence the structural equality via a reference equality == check
        assert(x == y);

        // structural equality via equals
        assert(x.equals(y));
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
}