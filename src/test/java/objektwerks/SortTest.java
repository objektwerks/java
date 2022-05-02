package objektwerks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

class SortTest {
    @Test void comparableSortTest() {
        var fred = new Person("fred", "flintstone");
        var barney = new Person("barney", "rubble");

        var persons = List.of(fred, barney);
        var sortedPersons = persons.stream().sorted().toList();
        assert(sortedPersons.get(0).equals(fred));
    }

    @Test void comparatorSortTest() {
        var pebbles = new Person("pebbles", "flintstone");
        var bammbamm = new Person("bamm-bamm", "rubble");

        var persons = List.of(pebbles, bammbamm);
        var byFirstComparator = Comparator.comparing(Person::first);
        var sortedPersonsByComparator = persons.stream().sorted(byFirstComparator).toList();
        assert(sortedPersonsByComparator.get(0).equals(bammbamm));
    }

    @Test void lambdaSortTest() {
        var wilma = new Person("wilma", "flintstone");
        var betty = new Person("betty", "rubble");

        var persons = new ArrayList<Person>();
        persons.add(wilma);
        persons.add(betty);

        persons.sort( (p1, p2) -> p1.last().compareTo(p2.last()) );
        assert(persons.get(0).equals(wilma));
    }
}