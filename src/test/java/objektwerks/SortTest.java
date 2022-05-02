package objektwerks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

// See EqualityTest for Person class.
class SortTest {
    @Test void comparableSortTest() {
        var fred = new Person("fred", "flintstone");
        var barney = new Person("barney", "rebel");

        var persons = List.of(fred, barney);
        var sortedPersons = persons.stream().sorted().toList();
        assert(sortedPersons.get(0).equals(fred));
    }

    @Test void comparatorSortTest() {
        var fred = new Person("fred", "flintstone");
        var barney = new Person("barney", "rebel");

        var persons = List.of(fred, barney);
        var byFirstComparator = Comparator.comparing(Person::first);
        var sortedPersonsByComparator = persons.stream().sorted(byFirstComparator).toList();
        assert(sortedPersonsByComparator.get(0).equals(barney));
    }

    @Test void lambdaSortTest() {
        var wilma = new Person("wilma", "flintstone");
        var betty = new Person("betty", "rebel");

        var persons = new ArrayList<Person>();
        persons.add(wilma);
        persons.add(betty);

        persons.sort( (p1, p2) -> p1.last().compareTo(p2.last()) );
        assert(persons.get(0).equals(wilma));
    }
}